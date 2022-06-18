package net.moewes.dao;

import com.microsoft.azure.storage.table.TableServiceEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MyEntity extends TableServiceEntity {

    private String name;
    private String surname;

    public MyEntity(String pkey, String rkey) {
        this.partitionKey = pkey;
        this.rowKey = rkey;
    }
}
