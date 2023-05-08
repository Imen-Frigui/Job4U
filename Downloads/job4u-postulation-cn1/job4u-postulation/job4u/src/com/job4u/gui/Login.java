package com.job4u.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.job4u.MainApp;
import com.job4u.gui.uikit.BaseForm;
import com.job4u.gui.uikit.NewsfeedForm;
import com.job4u.gui.uikit.SignUpForm;

public class Login extends BaseForm {

    public static Form loginForm;

    public Login() {
        super("Connexion", new BorderLayout());
        loginForm = this;
        addGUIs();
    }

    private void addGUIs() {

        getTitleArea().setUIID("Container");
        setUIID("SignIn");

        add(BorderLayout.NORTH, new Label(MainApp.res.getImage("Logo.png"), "LogoLabel"));

        TextField username = new TextField("", "Username", 20, TextField.ANY);
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        username.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        Button signIn = new Button("Sign In");
        Button signUp = new Button("Sign Up");
        signUp.addActionListener(e -> new SignUpForm(MainApp.res).show());
        signUp.setUIID("Link");
        Label doneHaveAnAccount = new Label("Don't have an account?");

        Button backendBtn = new Button("Back end");
        backendBtn.addActionListener(l -> new com.job4u.gui.back.AccueilBack(this).show());

        Container content = BoxLayout.encloseY(
                new FloatingHint(username),
                createLineSeparator(),
                new FloatingHint(password),
                createLineSeparator(),
                signIn,
                backendBtn,
                FlowLayout.encloseCenter(doneHaveAnAccount, signUp)
        );
        content.setScrollableY(true);
        add(BorderLayout.CENTER, content);
        signIn.requestFocus();
        signIn.addActionListener(e -> new NewsfeedForm(MainApp.res).show());
    }

}
