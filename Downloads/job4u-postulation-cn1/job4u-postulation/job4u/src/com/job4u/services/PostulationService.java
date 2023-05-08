package com.job4u.services;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.*;
import com.codename1.ui.events.ActionListener;
import com.job4u.entities.Postulation;
import com.job4u.entities.User;
import com.job4u.utils.Statics;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostulationService {

    public static PostulationService instance = null;
    public int resultCode;
    private ConnectionRequest cr;
    private ArrayList<Postulation> listPostulations;


    private PostulationService() {
        cr = new ConnectionRequest();
    }

    public static PostulationService getInstance() {
        if (instance == null) {
            instance = new PostulationService();
        }
        return instance;
    }

    public ArrayList<Postulation> getAll() {
        listPostulations = new ArrayList<>();

        cr = new ConnectionRequest();
        cr.setUrl(Statics.BASE_URL + "/postulation");
        cr.setHttpMethod("GET");

        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                if (cr.getResponseCode() == 200) {
                    listPostulations = getList();
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

        return listPostulations;
    }

    private ArrayList<Postulation> getList() {
        try {
            Map<String, Object> parsedJson = new JSONParser().parseJSON(new CharArrayReader(
                    new String(cr.getResponseData()).toCharArray()
            ));
            List<Map<String, Object>> list = (List<Map<String, Object>>) parsedJson.get("root");

            for (Map<String, Object> obj : list) {
                Postulation postulation = new Postulation(
                        (int) Float.parseFloat(obj.get("id").toString()),

                        makeUser((Map<String, Object>) obj.get("user")),
                        (String) obj.get("adresse"),
                        (String) obj.get("email"),
                        new SimpleDateFormat("dd-MM-yyyy").parse((String) obj.get("date"))

                );

                listPostulations.add(postulation);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return listPostulations;
    }

    public User makeUser(Map<String, Object> obj) {
        if (obj == null) {
            return null;
        }
        User user = new User();
        user.setId((int) Float.parseFloat(obj.get("id").toString()));
        user.setEmail((String) obj.get("email"));
        return user;
    }

    public int add(Postulation postulation) {

        cr = new ConnectionRequest();

        cr.setHttpMethod("POST");
        cr.setUrl(Statics.BASE_URL + "/postulation/add");

        cr.addArgument("user", String.valueOf(postulation.getUser().getId()));
        cr.addArgument("adresse", postulation.getAdresse());
        cr.addArgument("email", postulation.getEmail());
        cr.addArgument("date", new SimpleDateFormat("dd-MM-yyyy").format(postulation.getDate()));


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

    public int edit(Postulation postulation) {

        cr = new ConnectionRequest();
        cr.setHttpMethod("POST");
        cr.setUrl(Statics.BASE_URL + "/postulation/edit");
        cr.addArgument("id", String.valueOf(postulation.getId()));

        cr.addArgument("user", String.valueOf(postulation.getUser().getId()));
        cr.addArgument("adresse", postulation.getAdresse());
        cr.addArgument("email", postulation.getEmail());
        cr.addArgument("date", new SimpleDateFormat("dd-MM-yyyy").format(postulation.getDate()));


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

    public int delete(int postulationId) {
        cr = new ConnectionRequest();
        cr.setUrl(Statics.BASE_URL + "/postulation/delete");
        cr.setHttpMethod("POST");
        cr.addArgument("id", String.valueOf(postulationId));

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
