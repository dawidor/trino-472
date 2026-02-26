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

public class ColumnInfo
{
    @JsonProperty("name")
    private String name;

    @JsonProperty("type_text")
    private String typeText;

    @JsonProperty("type_json")
    private String typeJson;

    @JsonProperty("type_name")
    private String typeName;

    @JsonProperty("type_precision")
    private Integer typePrecision;

    @JsonProperty("type_scale")
    private Integer typeScale;

    @JsonProperty("type_interval_type")
    private String typeIntervalType;

    @JsonProperty("position")
    private Integer position;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("nullable")
    private Boolean nullable;

    @JsonProperty("partition_index")
    private Integer partitionIndex;

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

    @JsonProperty("type_text")
    public String getTypeText()
    {
        return typeText;
    }

    @JsonProperty("type_text")
    public void setTypeText(String typeText)
    {
        this.typeText = typeText;
    }

    @JsonProperty("type_json")
    public String getTypeJson()
    {
        return typeJson;
    }

    @JsonProperty("type_json")
    public void setTypeJson(String typeJson)
    {
        this.typeJson = typeJson;
    }

    @JsonProperty("type_name")
    public String getTypeName()
    {
        return typeName;
    }

    @JsonProperty("type_name")
    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    @JsonProperty("type_precision")
    public Integer getTypePrecision()
    {
        return typePrecision;
    }

    @JsonProperty("type_precision")
    public void setTypePrecision(Integer typePrecision)
    {
        this.typePrecision = typePrecision;
    }

    @JsonProperty("type_scale")
    public Integer getTypeScale()
    {
        return typeScale;
    }

    @JsonProperty("type_scale")
    public void setTypeScale(Integer typeScale)
    {
        this.typeScale = typeScale;
    }

    @JsonProperty("type_interval_type")
    public String getTypeIntervalType()
    {
        return typeIntervalType;
    }

    @JsonProperty("type_interval_type")
    public void setTypeIntervalType(String typeIntervalType)
    {
        this.typeIntervalType = typeIntervalType;
    }

    @JsonProperty("position")
    public Integer getPosition()
    {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Integer position)
    {
        this.position = position;
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

    @JsonProperty("nullable")
    public Boolean getNullable()
    {
        return nullable;
    }

    @JsonProperty("nullable")
    public void setNullable(Boolean nullable)
    {
        this.nullable = nullable;
    }

    @JsonProperty("partition_index")
    public Integer getPartitionIndex()
    {
        return partitionIndex;
    }

    @JsonProperty("partition_index")
    public void setPartitionIndex(Integer partitionIndex)
    {
        this.partitionIndex = partitionIndex;
    }
}
