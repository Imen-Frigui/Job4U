package com.job4u.services;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.*;
import com.codename1.ui.events.ActionListener;
import com.job4u.entities.Societe;
import com.job4u.utils.Statics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SocieteService {

    public static SocieteService instance = null;
    public int resultCode;
    private ConnectionRequest cr;
    private ArrayList<Societe> listSocietes;


    private SocieteService() {
        cr = new ConnectionRequest();
    }

    public static SocieteService getInstance() {
        if (instance == null) {
            instance = new SocieteService();
        }
        return instance;
    }

    public ArrayList<Societe> getAll() {
        listSocietes = new ArrayList<>();

        cr = new ConnectionRequest();
        cr.setUrl(Statics.BASE_URL + "/societe");
        cr.setHttpMethod("GET");

        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                if (cr.getResponseCode() == 200) {
                    listSocietes = getList();
                }

                cr.removeResponseListener(this);
            }
        });

        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSocietes;
    }

    private ArrayList<Societe> getList() {
        try {
            Map<String, Object> parsedJson = new JSONParser().parseJSON(new CharArrayReader(
                    new String(cr.getResponseData()).toCharArray()
            ));
            List<Map<String, Object>> list = (List<Map<String, Object>>) parsedJson.get("root");

            for (Map<String, Object> obj : list) {
                Societe societe = new Societe(
                        (int) Float.parseFloat(obj.get("id").toString()),

                        (String) obj.get("adresse"),
                        (String) obj.get("email"),
                        (String) obj.get("tel"),
                        (String) obj.get("domaine"),
                        (String) obj.get("image")

                );

                listSocietes.add(societe);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listSocietes;
    }

    public int add(Societe societe) {

        MultipartRequest cr = new MultipartRequest();
        cr.setFilename("file", "Societe.jpg");


        cr.setHttpMethod("POST");
        cr.setUrl(Statics.BASE_URL + "/societe/add");

        cr.addArgumentNoEncoding("image", societe.getImage());

        cr.addArgumentNoEncoding("adresse", societe.getAdresse());
        cr.addArgumentNoEncoding("email", societe.getEmail());
        cr.addArgumentNoEncoding("tel", societe.getTel());
        cr.addArgumentNoEncoding("domaine", societe.getDomaine());
        cr.addArgumentNoEncoding("image", societe.getImage());


        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultCode = cr.getResponseCode();
                cr.removeResponseListener(this);
            }
        });
        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception ignored) {

        }
        return resultCode;
    }

    public int edit(Societe societe, boolean imageEdited) {

        MultipartRequest cr = new MultipartRequest();
        cr.setFilename("file", "Societe.jpg");

        cr.setHttpMethod("POST");
        cr.setUrl(Statics.BASE_URL + "/societe/edit");
        cr.addArgumentNoEncoding("id", String.valueOf(societe.getId()));

        if (imageEdited) {
            try {
                cr.addData("file", societe.getImage(), "image/jpeg");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            cr.addArgumentNoEncoding("image", societe.getImage());
        }

        cr.addArgumentNoEncoding("adresse", societe.getAdresse());
        cr.addArgumentNoEncoding("email", societe.getEmail());
        cr.addArgumentNoEncoding("tel", societe.getTel());
        cr.addArgumentNoEncoding("domaine", societe.getDomaine());
        cr.addArgumentNoEncoding("image", societe.getImage());


        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultCode = cr.getResponseCode();
                cr.removeResponseListener(this);
            }
        });
        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception ignored) {

        }
        return resultCode;
    }

    public int delete(int societeId) {
        cr = new ConnectionRequest();
        cr.setUrl(Statics.BASE_URL + "/societe/delete");
        cr.setHttpMethod("POST");
        cr.addArgument("id", String.valueOf(societeId));

        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cr.removeResponseListener(this);
            }
        });

        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cr.getResponseCode();
    }
}
