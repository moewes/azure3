package net.moewes.dao;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.TableOperation;
import com.microsoft.azure.storage.table.TableQuery;
import lombok.SneakyThrows;
import net.moewes.TableStorage;

@ApplicationScoped
public class MyDao {

    @Inject
    TableStorage tableStorage;


    @SneakyThrows
    public void create(MyEntity entity) {

        CloudTable cloudTable = tableStorage.getCloudTable("people");
        cloudTable.execute(
                TableOperation.insertOrMerge(entity));
    }

    @SneakyThrows
    public List<MyEntity> getAll() {

        CloudTable cloudTable = tableStorage.getCloudTable("people");

        List<MyEntity> result = new ArrayList<>();

        TableQuery<MyEntity> query = TableQuery.from(MyEntity.class);
        cloudTable.execute(query).forEach(item -> result.add(item));

        return result;
    }
}

