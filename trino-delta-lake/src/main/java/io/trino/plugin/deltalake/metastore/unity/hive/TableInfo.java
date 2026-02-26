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

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class TableInfo
{
    @JsonProperty("name")
    private String name;

    @JsonProperty("catalog_name")
    private String catalogName;

    @JsonProperty("schema_name")
    private String schemaName;

    @JsonProperty("table_type")
    private String tableType;

    @JsonProperty("data_source_format")
    private String dataSourceFormat;

    @JsonProperty("columns")
    private List<ColumnInfo> columns;

    @JsonProperty("storage_location")
    private String storageLocation;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("properties")
    private Map<String, String> properties;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("created_at")
    private Long createdAt;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("updated_at")
    private Long updatedAt;

    @JsonProperty("updated_by")
    private String updatedBy;

    @JsonProperty("table_id")
    private String tableId;

    @JsonProperty("name")
    public String getName()
    {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name)
    {
        this.name = name;
    }

    @JsonProperty("catalog_name")
    public String getCatalogName()
    {
        return catalogName;
    }

    @JsonProperty("catalog_name")
    public void setCatalogName(String catalogName)
    {
        this.catalogName = catalogName;
    }

    @JsonProperty("schema_name")
    public String getSchemaName()
    {
        return schemaName;
    }

    @JsonProperty("schema_name")
    public void setSchemaName(String schemaName)
    {
        this.schemaName = schemaName;
    }

    @JsonProperty("table_type")
    public String getTableType()
    {
        return tableType;
    }

    @JsonProperty("table_type")
    public void setTableType(String tableType)
    {
        this.tableType = tableType;
    }

    @JsonProperty("data_source_format")
    public String getDataSourceFormat()
    {
        return dataSourceFormat;
    }

    @JsonProperty("data_source_format")
    public void setDataSourceFormat(String dataSourceFormat)
    {
        this.dataSourceFormat = dataSourceFormat;
    }

    @JsonProperty("columns")
    public List<ColumnInfo> getColumns()
    {
        return columns;
    }

    @JsonProperty("columns")
    public void setColumns(List<ColumnInfo> columns)
    {
        this.columns = columns;
    }

    @JsonProperty("storage_location")
    public String getStorageLocation()
    {
        return storageLocation;
    }

    @JsonProperty("storage_location")
    public void setStorageLocation(String storageLocation)
    {
        this.storageLocation = storageLocation;
    }

    @JsonProperty("comment")
    public String getComment()
    {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    @JsonProperty("properties")
    public Map<String, String> getProperties()
    {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Map<String, String> properties)
    {
        this.properties = properties;
    }

    @JsonProperty("owner")
    public String getOwner()
    {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    @JsonProperty("created_at")
    public Long getCreatedAt()
    {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(Long createdAt)
    {
        this.createdAt = createdAt;
    }

    @JsonProperty("created_by")
    public String getCreatedBy()
    {
        return createdBy;
    }

    @JsonProperty("created_by")
    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    @JsonProperty("updated_at")
    public Long getUpdatedAt()
    {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(Long updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("updated_by")
    public String getUpdatedBy()
    {
        return updatedBy;
    }

    @JsonProperty("updated_by")
    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    @JsonProperty("table_id")
    public String getTableId()
    {
        return tableId;
    }

    @JsonProperty("table_id")
    public void setTableId(String tableId)
    {
        this.tableId = tableId;
    }
}
