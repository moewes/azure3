package net.moewes.app.todo;

import com.microsoft.azure.storage.table.TableServiceEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Todo extends TableServiceEntity {

    private String description = "";
    private boolean done;

    public Todo(String partitionKey, String rowKey) {
        super();
        setPartitionKey(partitionKey);
        setRowKey(rowKey);
    }

}
