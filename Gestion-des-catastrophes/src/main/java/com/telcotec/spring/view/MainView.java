package com.telcotec.spring.view;


import com.vaadin.ui.*;


import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.server.VaadinRequest;


@SpringUI(path="/Views")
public class MainView extends UI{

	
	
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

		this.setContent(mainLyout);
		
	}

	private void setHeader() {
		HorizontalLayout  header=new HorizontalLayout();
		header.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		Label title = new Label("weather APP");
		header.addComponent(title);
		mainLyout.addComponent(header);
	}

	
	
}
