package com.cloudctrl.seaside.demo;

import com.cloudctrl.seaside.bootstrap.BootstrapNavbar;
import com.cloudctrl.seaside.bootstrap.MenuItem;
import com.cloudctrl.seaside.canvas.HtmlCanvas;
import com.cloudctrl.seaside.component.HtmlRenderable;

import java.awt.*;
import java.util.Arrays;

public class DemoPage implements HtmlRenderable {

    private BootstrapNavbar navbar;
    private HtmlRenderable mainPanel;

    public DemoPage(HtmlRenderable mainPanel) {
        super();
        this.navbar = new BootstrapNavbar();
        this.navbar.setBrandName("Seaside");
        this.navbar.setMenuItems(Arrays.asList(
                new MenuItem("First"),
                new MenuItem("Seconds"),
                new MenuItem("Third")
        ));
        this.mainPanel = mainPanel;
    }

    @Override
    public void renderContentOn(HtmlCanvas html) {

        html.render(navbar);

        html.div().cssClass("container").with(() -> {
            html.div().cssClass("row").with(() -> {
                html.div().cssClass("col-sm").with(() -> {
                    html.text("pipo");
                });
                html.div().cssClass("col-sm").with(() -> {
                    html.render(mainPanel);
                });
                html.div().cssClass("col-sm").with(() -> {
                    html.text("pipo");
                });
            });
        });

        html.script()
                .setUrl("https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js")
                .setIntegrity("sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf")
                .beAnonymous();
    }
}
