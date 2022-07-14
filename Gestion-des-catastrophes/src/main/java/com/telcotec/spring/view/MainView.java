package com.telcotec.spring.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.spring.annotation.*;

import com.vaadin.ui.*;


@SpringUI(path="/View")
public class MainView extends UI{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public VerticalLayout mainLyout;

	@Override
    protected void init(VaadinRequest request) {
		mainLayout();
		setHeader();
    }
	
	private void mainLayout() {
		// TODO Auto-generated method stub
		mainLyout=new VerticalLayout();
		mainLyout.setWidth("100%");
		mainLyout.setSpacing(true);
		mainLyout.setMargin(true);
		mainLyout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		//setContent(mainLyout);
		
	}

	private void setHeader() {
		HorizontalLayout  header=new HorizontalLayout();
		header.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		Label title = new Label("weather APP");
		header.addComponent(title);
		mainLyout.addComponent(header);
	}
	
}
