package net.moewes.app.todo;

import java.net.URISyntaxException;
import java.security.Principal;
import java.util.UUID;

import com.microsoft.azure.storage.StorageException;
import io.quarkus.oidc.IdToken;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import net.moewes.Dao;
import net.moewes.cloudui.UiBinder;
import net.moewes.cloudui.UiComponent;
import net.moewes.cloudui.annotations.CloudUiView;
import net.moewes.cloudui.lifecycle.AfterDataBindingObserver;
import net.moewes.cloudui.quarkus.runtime.CloudUi;
import net.moewes.cloudui.ui5.Ui5Bar;
import net.moewes.cloudui.ui5.Ui5Button;
import net.moewes.cloudui.ui5.Ui5Input;
import net.moewes.cloudui.ui5.Ui5Label;
import net.moewes.ui.Ui5BaseView;
import net.moewes.ui.util.FormLayout;
import org.eclipse.microprofile.jwt.JsonWebToken;


@CloudUiView("/todos/edit")
public class TodoEditView extends Ui5BaseView implements AfterDataBindingObserver {

    @Inject
    Dao<Todo> dao;

    @Inject
    CloudUi ui;

   @Inject
   @IdToken
   JsonWebToken idToken;

    @Inject
    SecurityIdentity identity;

    @Inject
    TodoAppController appController;

    private Ui5Button saveButton;
    private Ui5Button deleteButton;
    private Ui5Bar bottomBar;
    private Todo item;

    public TodoEditView() {
        super("Edit Todo");
    }

    @PostConstruct
    public void createView() {

        item = appController.getItem();

        page.getElement().setAttribute("floating-footer", "true"); // FIXME

        Ui5Button backButton = new Ui5Button();
        backButton.setIcon("nav-back");
        backButton.setDesign(Ui5Button.Design.TRANSPARENT);
        backButton.addEventListener("click", event -> {
            ui.navigate(TodoListView.class);
        });
        bar.addStartContent(backButton);

        bottomBar = new Ui5Bar();
        bottomBar.setDesign(Ui5Bar.Design.FLOATING_FOOTER);
        bottomBar.getElement().setAttribute("slot", "footer"); // FIXME
        page.add(bottomBar);

        deleteButton = new Ui5Button();
        deleteButton.setIcon("delete");
        deleteButton.setText("Delete");
        deleteButton.setDesign(Ui5Button.Design.NEGATIVE);
        deleteButton.setId("delete");
        //   bottomBar.addEndContent(deleteButton);

        deleteButton.addClickHandler(uiEvent -> {
            try {
                dao.delete(item);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (StorageException e) {
                e.printStackTrace();
            }
            ui.navigate(TodoListView.class);
        });

        saveButton = new Ui5Button();
        saveButton.setIcon("save");
        saveButton.setText("Save");
        saveButton.setDesign(Ui5Button.Design.EMPHASIZED);
        saveButton.setId("save");

        // bottomBar.addEndContent(saveButton);

        FormLayout form = new FormLayout();

        Ui5Label descriptionLabel = new Ui5Label("Description");
        descriptionLabel.setShowColon(true);
        descriptionLabel.setRequired(true);

        Ui5Input descriptionField = new Ui5Input();
        descriptionField.getElement().setAttribute("style", "width: 100%");
        UiBinder binder = new UiBinder();
        binder.bind(descriptionField, item::getDescription, item::setDescription);

        form.addFormItem(descriptionLabel, descriptionField);

        Ui5Label userLabel = new Ui5Label("User");

        Ui5Input userField = new Ui5Input();
        userField.setReadOnly(true);

        Principal principal = identity.getPrincipal(); // FIXME

        if (idToken != null) {
            userField.setValue(idToken.getSubject());
        } else {
            userField.setValue("no token");
        }

        form.addFormItem(userLabel, userField);

        add(form);

        UiComponent partitionKeyField = new UiComponent("input");
        add(partitionKeyField);
        partitionKeyField.getElement().setAttribute("hidden", "true");
        binder = new UiBinder();
        binder.bind(partitionKeyField, item::getPartitionKey, item::setPartitionKey);

        UiComponent rowKeyField = new UiComponent("input");
        add(rowKeyField);
        rowKeyField.getElement().setAttribute("hidden", "true");
        binder = new UiBinder();
        binder.bind(rowKeyField, item::getRowKey, item::setRowKey);

        UiComponent etagField = new UiComponent("input");
        add(etagField);
        etagField.getElement().setAttribute("hidden", "true");
        binder = new UiBinder();
        binder.bind(etagField, item::getEtag, item::setEtag);

        saveButton.addEventListener("click", event -> {
            if (item.getPartitionKey() == null) {
                item.setPartitionKey(UUID.randomUUID().toString());
                item.setRowKey(UUID.randomUUID().toString());
            }
            try {
                dao.save(item);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (StorageException e) {
                e.printStackTrace();
            }
            ui.navigate(TodoListView.class);
        });
    }

    @Override
    public void afterDataBinding() {

        if (item.getPartitionKey() != null) {
            bottomBar.addEndContent(deleteButton);
            deleteButton.setId("delete");
        }
        bottomBar.addEndContent(saveButton);
        saveButton.setId("save");
    }
}