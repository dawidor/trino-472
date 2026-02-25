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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import io.airlift.json.JsonCodec;
import io.trino.filesystem.Location;
import io.trino.metastore.*;
import io.trino.plugin.hive.HiveStorageFormat;
import io.trino.plugin.hive.metastore.file.Column;
import io.trino.plugin.hive.metastore.file.TableMetadata;
import io.trino.spi.connector.SchemaTableName;
import io.trino.spi.function.LanguageFunction;
import io.trino.spi.predicate.TupleDomain;
import io.trino.spi.security.RoleGrant;

import java.util.*;

import static io.trino.metastore.StorageFormat.VIEW_STORAGE_FORMAT;
import static io.trino.metastore.Table.TABLE_COMMENT;
import static io.trino.plugin.hive.HiveSchemaProperties.LOCATION_PROPERTY;
import static io.trino.plugin.hive.metastore.file.FileHiveMetastore.SchemaType.TABLE;
import static java.util.Objects.requireNonNull;

public class UnityHiveMetastore
        implements HiveMetastore
{
    private final JsonCodec<TableMetadata> tableCodec = JsonCodec.jsonCodec(TableMetadata.class);

    @Override
    public Optional<Database> getDatabase(String databaseName)
    {
        return Optional.empty();
    }

    @Override
    public List<String> getAllDatabases()
    {
        List <String> result = new ArrayList<String>();
        result.add("pdx_dev");
        result.add("pdx_uat");
        return result;
    }

    @Override
    public Optional<Table> getTable(String databaseName, String tableName)
    {
        requireNonNull(databaseName, "databaseName is null");
        requireNonNull(tableName, "tableName is null");

        Map <String,String> params = new HashMap<>();
        Map <String,String> m = new HashMap<>();
        Column c = new Column("c1", HiveType.HIVE_INT, Optional.of("test column"), m);
        List<Column>cols = new ArrayList<>();
        cols.add(c);

        Storage s = Storage
                .builder()
                .setLocation("s3://abcd")
                .build();

        return Optional.of(new Table(
                databaseName,
                tableName,
                Optional.of("Dawidowicz Rafal"),
                "TABLE",
                s,
                Column.toMetastoreModel(cols),
                Column.toMetastoreModel(cols),
                params,
                null,
                null,
                OptionalLong.empty()));
    }

    @Override
    public Map<String, HiveColumnStatistics> getTableColumnStatistics(String databaseName, String tableName, Set<String> columnNames)
    {
        return Map.of();
    }

    @Override
    public Map<String, Map<String, HiveColumnStatistics>> getPartitionColumnStatistics(String databaseName, String tableName, Set<String> partitionNames, Set<String> columnNames)
    {
        return Map.of();
    }

    @Override
    public void updateTableStatistics(String databaseName, String tableName, OptionalLong acidWriteId, StatisticsUpdateMode mode, PartitionStatistics statisticsUpdate)
    {
    }

    @Override
    public void updatePartitionStatistics(Table table, StatisticsUpdateMode mode, Map<String, PartitionStatistics> partitionUpdates)
    {
    }

    @Override
    public List<TableInfo> getTables(String databaseName)
    {
        Set<TableInfo> tables = new HashSet<>();
        TableInfo ti = new TableInfo(new SchemaTableName(databaseName, "rafitest3"),
                TableInfo.ExtendedRelationType.fromTableTypeAndComment("TABLE", "test table"));
        tables.add(ti);
        return ImmutableList.copyOf(tables);
    }

    @Override
    public List<String> getTableNamesWithParameters(String databaseName, String parameterKey, ImmutableSet<String> parameterValues)
    {
        return List.of();
    }

    @Override
    public void createDatabase(Database database)
    {
    }

    @Override
    public void dropDatabase(String databaseName, boolean deleteData)
    {
    }

    @Override
    public void renameDatabase(String databaseName, String newDatabaseName)
    {
    }

    @Override
    public void setDatabaseOwner(String databaseName, HivePrincipal principal)
    {
    }

    @Override
    public void createTable(Table table, PrincipalPrivileges principalPrivileges)
    {
    }

    @Override
    public void dropTable(String databaseName, String tableName, boolean deleteData)
    {
    }

    @Override
    public void replaceTable(String databaseName, String tableName, Table newTable, PrincipalPrivileges principalPrivileges)
    {
    }

    @Override
    public void renameTable(String databaseName, String tableName, String newDatabaseName, String newTableName)
    {
    }

    @Override
    public void commentTable(String databaseName, String tableName, Optional<String> comment)
    {
    }

    @Override
    public void setTableOwner(String databaseName, String tableName, HivePrincipal principal)
    {
    }

    @Override
    public void commentColumn(String databaseName, String tableName, String columnName, Optional<String> comment)
    {
    }

    @Override
    public void addColumn(String databaseName, String tableName, String columnName, HiveType columnType, String columnComment)
    {
    }

    @Override
    public void renameColumn(String databaseName, String tableName, String oldColumnName, String newColumnName)
    {
    }

    @Override
    public void dropColumn(String databaseName, String tableName, String columnName)
    {
    }

    @Override
    public Optional<Partition> getPartition(Table table, List<String> partitionValues)
    {
        return Optional.empty();
    }

    @Override
    public Optional<List<String>> getPartitionNamesByFilter(String databaseName, String tableName, List<String> columnNames, TupleDomain<String> partitionKeysFilter)
    {
        return Optional.empty();
    }

    @Override
    public Map<String, Optional<Partition>> getPartitionsByNames(Table table, List<String> partitionNames)
    {
        return Map.of();
    }

    @Override
    public void addPartitions(String databaseName, String tableName, List<PartitionWithStatistics> partitions)
    {
    }

    @Override
    public void dropPartition(String databaseName, String tableName, List<String> parts, boolean deleteData)
    {
    }

    @Override
    public void alterPartition(String databaseName, String tableName, PartitionWithStatistics partition)
    {
    }

    @Override
    public void createRole(String role, String grantor)
    {
    }

    @Override
    public void dropRole(String role)
    {
    }

    @Override
    public Set<String> listRoles()
    {
        return Set.of();
    }

    @Override
    public void grantRoles(Set<String> roles, Set<HivePrincipal> grantees, boolean adminOption, HivePrincipal grantor)
    {
    }

    @Override
    public void revokeRoles(Set<String> roles, Set<HivePrincipal> grantees, boolean adminOption, HivePrincipal grantor)
    {
    }

    @Override
    public Set<RoleGrant> listRoleGrants(HivePrincipal principal)
    {
        return Set.of();
    }

    @Override
    public void grantTablePrivileges(String databaseName, String tableName, String tableOwner, HivePrincipal grantee, HivePrincipal grantor, Set<HivePrivilegeInfo.HivePrivilege> privileges, boolean grantOption)
    {
    }

    @Override
    public void revokeTablePrivileges(String databaseName, String tableName, String tableOwner, HivePrincipal grantee, HivePrincipal grantor, Set<HivePrivilegeInfo.HivePrivilege> privileges, boolean grantOption)
    {
    }

    @Override
    public Set<HivePrivilegeInfo> listTablePrivileges(String databaseName, String tableName, Optional<String> tableOwner, Optional<HivePrincipal> principal)
    {
        return Set.of();
    }

    @Override
    public boolean functionExists(String databaseName, String functionName, String signatureToken)
    {
        return false;
    }

    @Override
    public Collection<LanguageFunction> getAllFunctions(String databaseName)
    {
        return List.of();
    }

    @Override
    public Collection<LanguageFunction> getFunctions(String databaseName, String functionName)
    {
        return List.of();
    }

    @Override
    public void createFunction(String databaseName, String functionName, LanguageFunction function)
    {
    }

    @Override
    public void replaceFunction(String databaseName, String functionName, LanguageFunction function)
    {
    }

    @Override
    public void dropFunction(String databaseName, String functionName, String signatureToken)
    {
    }
}
