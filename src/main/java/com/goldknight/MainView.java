package com.goldknight;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = true)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout implements Serializable {

    @Autowired
    private Itach itach;
 //   private Itach itach;
    private IFrame tvFrame = new IFrame("http://24.80.132.186:5080/LiveApp/play.html?name=773464807825636547094208");



    public MainView(@Autowired GreetService service) {

        addClassName("centered-content");


        tvFrame.addClassName("iframe");
        tvFrame.setHeight("315px");
        tvFrame.setWidth("560px");


        tvFrame.setAllow("accelerometer;  encrypted-media; gyroscope; picture-in-picture");
        tvFrame.getElement().setAttribute("allowfullscreen", true);
        tvFrame.getElement().setAttribute("frameborder", "0");
        tvFrame.getElement().setAttribute("margin", "0");
        tvFrame.getElement().setAttribute("padding", "0");




        add(tvFrame);
        tvFrame.setVisible(false);

        ArrayList<TV> tvs = new ArrayList<>();
        tvs.add(new TV("CNN","USA",33));
        tvs.add(new TV("BBC","UK",36));
        tvs.add(new TV("CBC","CAN",3));

        Grid<TV> grid = new Grid<>(TV.class);
        grid.setItems(tvs);
        grid.setColumns("name","country","channel");
        add(grid);

        grid.addItemClickListener(e->{


                    itach = new Itach();
                    //   Notification.show(e.getItem().getUrl());
                    tvFrame.setVisible(true);
                     int x = e.getItem().getChannel();
                    int a=0;
                    int b=0;
                    int c=0;

                    if (x<10)
                    {

                        itach.send(String.valueOf(x));
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                    }

                   if (x<100 && x>=10)
                    {
                        b=x/10;
                        c=x-b*10;

                        itach.send(String.valueOf(b));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        itach.send(String.valueOf(c));

                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }


                    }

                    itach.closeAll();



                }


                );


    }

}
