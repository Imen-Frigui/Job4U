package com.job4u.gui.front.societe;


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


    public AfficherToutSociete(Resources res) {
        super(new BoxLayout(BoxLayout.Y_AXIS));

        Toolbar tb = new Toolbar(true);
        tb.setUIID("CustomToolbar");
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Societe");
        getContentPane().setScrollVisible(false);

        super.addSideMenu(res);

        Image img = res.getImage("profile-background.jpg");
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }

        addGUIs();
        addActions();


    }

    public void refresh() {
        this.removeAll();
        addGUIs();
        addActions();
        this.refreshTheme();
    }


    String selectedAddresse;

    ArrayList<Societe> listSocietes;
    ArrayList<Societe> displayListSocietes;

    private void addGUIs() {
        listSocietes = SocieteService.getInstance().getAll();

        if (displayListSocietes == null) {
            displayListSocietes = SocieteService.getInstance().getAll();
        }

        Container container = new Container();
        container.setPreferredH(250);
        this.add(container);

        addBtn = new Button("Ajouter");
        addBtn.setUIID("buttonWhiteCenter");
        this.add(addBtn);

        Container filtersContainer = new Container(BoxLayout.x());
        filtersContainer.setScrollableX(true);

        PickerComponent addresseFilterButton = PickerComponent.createStrings("Addresse");
        String[] strings1;
        strings1 = new String[listSocietes.size()];
        int i = 0;
        for (Societe societe : listSocietes) {
            strings1[i] = societe.getAdresse();
            i++;
        }
        addresseFilterButton.getPicker().addActionListener(l -> {
            displayListSocietes = new ArrayList<>();
            for (Societe societe : listSocietes) {
                if (societe.getAdresse().equalsIgnoreCase(addresseFilterButton.getPicker().getText())) {
                    displayListSocietes.add(societe);
                }
            }
            this.refresh();
        });
        if (listSocietes.size() > 0) {
            addresseFilterButton.getPicker().setStrings(strings1);
        } else {
            addresseFilterButton.getPicker().setStrings("");
        }

        PickerComponent emailFilterButton = PickerComponent.createStrings("Email");
        String[] strings2;
        strings2 = new String[listSocietes.size()];
        int i2 = 0;
        for (Societe societe : listSocietes) {
            strings2[i2] = societe.getEmail();
            i2++;
        }
        emailFilterButton.getPicker().addActionListener(l -> {
            displayListSocietes = new ArrayList<>();
            for (Societe societe : listSocietes) {
                if (societe.getEmail().equalsIgnoreCase(emailFilterButton.getPicker().getText())) {
                    displayListSocietes.add(societe);
                }
            }
            this.refresh();
        });
        if (listSocietes.size() > 0) {
            emailFilterButton.getPicker().setStrings(strings2);
        } else {
            emailFilterButton.getPicker().setStrings("");
        }

        PickerComponent telFilterButton = PickerComponent.createStrings("Tel");
        String[] strings3;
        strings3 = new String[listSocietes.size()];
        int i3 = 0;
        for (Societe societe : listSocietes) {
            strings3[i3] = societe.getTel();
            i3++;
        }
        telFilterButton.getPicker().addActionListener(l -> {
            displayListSocietes = new ArrayList<>();
            for (Societe societe : listSocietes) {
                if (societe.getTel().equalsIgnoreCase(telFilterButton.getPicker().getText())) {
                    displayListSocietes.add(societe);
                }
            }
            this.refresh();
        });
        if (listSocietes.size() > 0) {
            telFilterButton.getPicker().setStrings(strings3);
        } else {
            telFilterButton.getPicker().setStrings("");
        }

        PickerComponent domaineFilterButton = PickerComponent.createStrings("Domaine");
        String[] strings4;
        strings4 = new String[listSocietes.size()];
        int i4 = 0;
        for (Societe societe : listSocietes) {
            strings4[i4] = societe.getDomaine();
            i4++;
        }
        domaineFilterButton.getPicker().addActionListener(l -> {
            displayListSocietes = new ArrayList<>();
            for (Societe societe : listSocietes) {
                if (societe.getDomaine().equalsIgnoreCase(domaineFilterButton.getPicker().getText())) {
                    displayListSocietes.add(societe);
                }
            }
            this.refresh();
        });
        if (listSocietes.size() > 0) {
            domaineFilterButton.getPicker().setStrings(strings4);
        } else {
            domaineFilterButton.getPicker().setStrings("");
        }


        filtersContainer.addAll(new Label("Filters : "), addresseFilterButton, emailFilterButton, telFilterButton, domaineFilterButton);

        this.add(filtersContainer);

        if (displayListSocietes.size() > 0) {
            for (Societe societe : displayListSocietes) {
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

    Label adresseLabel, emailLabel, telLabel, domaineLabel;

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