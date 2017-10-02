package it.geiweb.sascha.ComboboxEnumHandling;

import java.util.Comparator;
import java.util.EnumSet;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import it.geiweb.sascha.ComboboxEnumHandling.Enum.EnumContactAction;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Title("Combobox and Enum handling")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
               
        // new Vaadin 8 combobox definition
        ComboBox<EnumContactAction> cb = new ComboBox<EnumContactAction>();
       
        // just setting the combobox size using some java 8 tricks, you can disregards it
        	cb.setWidth( EnumSet.allOf(EnumContactAction.class).stream()
            		.map(EnumContactAction::getCaption)
            		.max(Comparator.comparingInt(String::length))
            		.get()
            		.length()+"em");

        		
        // get all values from enumerator and put them in the combobox
        cb.setItems(EnumSet.allOf(EnumContactAction.class));
        
        // combobox item must be selected (BLANK value handle the lack of real value)
        cb.setEmptySelectionAllowed(false);
        
        // preset to the blan value in ordr to avoid the 'null' value
        cb.setValue(EnumContactAction.BLANK);

        // here is where the captions in the combobox are handled
        cb.setItemCaptionGenerator(EnumContactAction::getCaption);

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Choosen value: '" + EnumContactAction.getCaption(cb.getValue())  
            + "', and this is the internal enum value: '" + cb.getValue() + "'"));
        });
        
        layout.addComponents(cb, button);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
