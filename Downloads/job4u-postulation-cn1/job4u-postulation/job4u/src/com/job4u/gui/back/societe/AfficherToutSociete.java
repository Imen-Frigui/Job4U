package com.job4u.gui.back.societe;


import com.codename1.components.ImageViewer;
import com.codename1.components.InteractionDialog;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.job4u.entities.Societe;
import com.job4u.gui.uikit.BaseForm;
import com.job4u.services.SocieteService;
import com.job4u.utils.Statics;

import java.util.ArrayList;

public class AfficherToutSociete extends BaseForm {

    Form previous;

    Resources theme = UIManager.initFirstTheme("/theme");

    public static Societe currentSociete = null;
    Button addBtn;


    public AfficherToutSociete(Form previous) {
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


        ArrayList<Societe> listSocietes = SocieteService.getInstance().getAll();


        if (listSocietes.size() > 0) {
            for (Societe societe : listSocietes) {
                Component model = makeSocieteModel(societe);
                this.add(model);
            }
        } else {
            this.add(new Label("Aucune donnée"));
        }
    }

    private void addActions() {
        addBtn.addActionListener(action -> {
            currentSociete = null;
            new AjouterSociete(this).show();
        });

    }

    Label adresseLabel, emailLabel, telLabel, domaineLabel, imageLabel;

    ImageViewer imageIV;


    private Container makeModelWithoutButtons(Societe societe) {
        Container societeModel = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        societeModel.setUIID("containerRounded");


        adresseLabel = new Label("Adresse : " + societe.getAdresse());
        adresseLabel.setUIID("labelDefault");

        emailLabel = new Label("Email : " + societe.getEmail());
        emailLabel.setUIID("labelDefault");

        telLabel = new Label("Tel : " + societe.getTel());
        telLabel.setUIID("labelDefault");

        domaineLabel = new Label("Domaine : " + societe.getDomaine());
        domaineLabel.setUIID("labelDefault");

        imageLabel = new Label("Image : " + societe.getImage());
        imageLabel.setUIID("labelDefault");

        if (societe.getImage() != null) {
            String url = Statics.SOCIETE_IMAGE_URL + societe.getImage();
            Image image = URLImage.createToStorage(
                    EncodedImage.createFromImage(theme.getImage("profile-pic.jpg").fill(1100, 500), false),
                    url,
                    url,
                    URLImage.RESIZE_SCALE
            );
            imageIV = new ImageViewer(image);
        } else {
            imageIV = new ImageViewer(theme.getImage("profile-pic.jpg").fill(1100, 500));
        }
        imageIV.setFocusable(false);

        societeModel.addAll(
                imageIV,
                adresseLabel, emailLabel, telLabel, domaineLabel
        );

        return societeModel;
    }

    Button editBtn, deleteBtn;
    Container btnsContainer;

    private Component makeSocieteModel(Societe societe) {

        Container societeModel = makeModelWithoutButtons(societe);

        btnsContainer = new Container(new BorderLayout());
        btnsContainer.setUIID("containerButtons");

        editBtn = new Button("Modifier");
        editBtn.setUIID("buttonWhiteCenter");
        editBtn.addActionListener(action -> {
            currentSociete = societe;
            new ModifierSociete(this).show();
        });

        deleteBtn = new Button("Supprimer");
        deleteBtn.setUIID("buttonWhiteCenter");
        deleteBtn.addActionListener(action -> {
            InteractionDialog dlg = new InteractionDialog("Confirmer la suppression");
            dlg.setLayout(new BorderLayout());
            dlg.add(BorderLayout.CENTER, new Label("Voulez vous vraiment supprimer ce societe ?"));
            Button btnClose = new Button("Annuler");
            btnClose.addActionListener((ee) -> dlg.dispose());
            Button btnConfirm = new Button("Confirmer");
            btnConfirm.addActionListener(actionConf -> {
                int responseCode = SocieteService.getInstance().delete(societe.getId());

                if (responseCode == 200) {
                    currentSociete = null;
                    dlg.dispose();
                    societeModel.remove();
                    this.refreshTheme();
                } else {
                    Dialog.show("Erreur", "Erreur de suppression du societe. Code d'erreur : " + responseCode, new Command("Ok"));
                }
            });
            Container btnContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
            btnContainer.addAll(btnClose, btnConfirm);
            dlg.addComponent(BorderLayout.SOUTH, btnContainer);
            dlg.show(800, 800, 0, 0);
        });

        btnsContainer.add(BorderLayout.WEST, editBtn);
        btnsContainer.add(BorderLayout.EAST, deleteBtn);


        societeModel.add(btnsContainer);

        return societeModel;
    }

}