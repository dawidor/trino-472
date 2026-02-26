/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trino.plugin.deltalake.metastore.unity.hive;

import io.airlift.http.client.HttpClient;
import io.airlift.http.client.JsonResponseHandler;
import io.airlift.http.client.Request;
import io.airlift.http.client.ResponseHandler;
import io.airlift.http.client.jetty.JettyHttpClient;
import io.airlift.json.JsonCodec;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

public class UnityCatalogClient
{
    private final HttpClient httpClient;
    private final String baseUrl;
    private final String bearerToken;

    public UnityCatalogClient(String baseUrl, String bearerToken)
    {
        this.baseUrl = baseUrl;
        this.bearerToken = bearerToken;
        this.httpClient = new JettyHttpClient();
    }

    public List<String> listSchemas(String catalog)
    {
        URI url = URI.create(baseUrl.trim() + "/schemas?catalog_name=" + catalog.trim());

        Request request = Request.Builder.prepareGet()
                .setUri(url)
                .setHeader("Accept", "application/json")
                .build();

        ResponseHandler<SchemaResponse, RuntimeException> handler =
                JsonResponseHandler.createJsonResponseHandler(JsonCodec.jsonCodec(SchemaResponse.class));

        SchemaResponse response = httpClient.execute(request, handler);
        List<String> schemaNames = response.getSchemas().stream()
                .map(SchemaInfo::getName)
                .collect(Collectors.toList());
        return schemaNames;
    }

    public List<String> listTables(String catalog, String schema)
    {
        URI url = URI.create(baseUrl + "/tables?catalog_name=" + catalog + "&schema_name=" + schema);

        Request request = Request.Builder.prepareGet()
                .setUri(url)
                .setHeader("Accept", "application/json")
                .build();

        ResponseHandler<TablesResponse, RuntimeException> handler =
                JsonResponseHandler.createJsonResponseHandler(JsonCodec.jsonCodec(TablesResponse.class));

        TablesResponse response = httpClient.execute(request, handler);
        List<String> tablesNames = response.getSchemas().stream()
                .map(TableInfo::getName)
                .collect(Collectors.toList());
        return tablesNames;
    }

    public TableInfo getTable(String catalog, String schema, String table)
    {
        URI url = URI.create(baseUrl + "/tables/" + catalog + "." + schema + "." + table);

        Request request = Request.Builder.prepareGet()
                .setUri(url)
                .setHeader("Accept", "application/json")
                .build();

        ResponseHandler<TableInfo, RuntimeException> handler =
                JsonResponseHandler.createJsonResponseHandler(JsonCodec.jsonCodec(TableInfo.class));

        TableInfo response = httpClient.execute(request, handler);
        return response;
    }
}
