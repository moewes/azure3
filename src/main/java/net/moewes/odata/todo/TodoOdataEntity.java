package net.moewes.odata.todo;

import lombok.Data;
import net.moewes.quarkus.odata.annotations.EntityKey;
import net.moewes.quarkus.odata.annotations.ODataEntity;

@ODataEntity("Todo")
@Data
public class TodoOdataEntity {

    @EntityKey
    private String partitionKey;
    @EntityKey
    private String rowKey;
    private String etag;
    private String description;
}
