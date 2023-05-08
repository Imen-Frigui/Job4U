package com.job4u.gui.back.postulation;


import com.codename1.components.InteractionDialog;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.job4u.entities.Postulation;
import com.job4u.gui.uikit.BaseForm;
import com.job4u.services.PostulationService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AfficherToutPostulation extends BaseForm {

    Form previous;

    public static Postulation currentPostulation = null;
    Button addBtn;


    public AfficherToutPostulation(Form previous) {
        super(new BoxLayout(BoxLayout.Y_AXIS));
        this.previous = previous;

        addGUIs();
        addActions();

        super.getToolbar().addMaterialCommandToLeftBar("  ", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

    public void refresh() {
        this.removeAll();
        addGUIs();
        addActions();
        this.refreshTheme();
    }

    private void addGUIs() {


        addBtn = new Button("Ajouter");
        addBtn.setUIID("buttonWhiteCenter");
        this.add(addBtn);


        ArrayList<Postulation> listPostulations = PostulationService.getInstance().getAll();


        if (listPostulations.size() > 0) {
            for (Postulation postulation : listPostulations) {
                Component model = makePostulationModel(postulation);
                this.add(model);
            }
        } else {
            this.add(new Label("Aucune donnée"));
        }
    }

    private void addActions() {
        addBtn.addActionListener(action -> {
            currentPostulation = null;
            new AjouterPostulation(this).show();
        });

    }

    Label userLabel, adresseLabel, emailLabel, dateLabel;


    private Container makeModelWithoutButtons(Postulation postulation) {
        Container postulationModel = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        postulationModel.setUIID("containerRounded");


        userLabel = new Label("User : " + postulation.getUser());
        userLabel.setUIID("labelDefault");

        adresseLabel = new Label("Adresse : " + postulation.getAdresse());
        adresseLabel.setUIID("labelDefault");

        emailLabel = new Label("Email : " + postulation.getEmail());
        emailLabel.setUIID("labelDefault");

        dateLabel = new Label("Date : " + new SimpleDateFormat("dd-MM-yyyy").format(postulation.getDate()));
        dateLabel.setUIID("labelDefault");

        userLabel = new Label("User : " + postulation.getUser().getEmail());
        userLabel.setUIID("labelDefault");


        postulationModel.addAll(

                userLabel, adresseLabel, emailLabel, dateLabel
        );

        return postulationModel;
    }

    Button editBtn, deleteBtn;
    Container btnsContainer;

    private Component makePostulationModel(Postulation postulation) {

        Container postulationModel = makeModelWithoutButtons(postulation);

        btnsContainer = new Container(new BorderLayout());
        btnsContainer.setUIID("containerButtons");

        editBtn = new Button("Modifier");
        editBtn.setUIID("buttonWhiteCenter");
        editBtn.addActionListener(action -> {
            currentPostulation = postulation;
            new ModifierPostulation(this).show();
        });

        deleteBtn = new Button("Supprimer");
        deleteBtn.setUIID("buttonWhiteCenter");
        deleteBtn.addActionListener(action -> {
            InteractionDialog dlg = new InteractionDialog("Confirmer la suppression");
            dlg.setLayout(new BorderLayout());
            dlg.add(BorderLayout.CENTER, new Label("Voulez vous vraiment supprimer ce postulation ?"));
            Button btnClose = new Button("Annuler");
            btnClose.addActionListener((ee) -> dlg.dispose());
            Button btnConfirm = new Button("Confirmer");
            btnConfirm.addActionListener(actionConf -> {
                int responseCode = PostulationService.getInstance().delete(postulation.getId());

                if (responseCode == 200) {
                    currentPostulation = null;
                    dlg.dispose();
                    postulationModel.remove();
                    this.refreshTheme();
                } else {
                    Dialog.show("Erreur", "Erreur de suppression du postulation. Code d'erreur : " + responseCode, new Command("Ok"));
                }
            });
            Container btnContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
            btnContainer.addAll(btnClose, btnConfirm);
            dlg.addComponent(BorderLayout.SOUTH, btnContainer);
            dlg.show(800, 800, 0, 0);
        });

        btnsContainer.add(BorderLayout.WEST, editBtn);
        btnsContainer.add(BorderLayout.EAST, deleteBtn);


        postulationModel.add(btnsContainer);

        return postulationModel;
    }

}