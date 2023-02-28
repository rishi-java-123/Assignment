package com.db.assignment.ecommerce.dtos;

import java.io.Serializable;

public class PurchaseMessageDto<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private T content;
	
	private PurchaseMessageTypeEnum messageType;
	
	

	public PurchaseMessageDto(T content, PurchaseMessageTypeEnum messageType) {
		super();
		this.content = content;
		this.setMessageType(messageType);
		
	}

	public PurchaseMessageDto() {
		super();
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public PurchaseMessageTypeEnum getMessageType() {
		return messageType;
	}

	public void setMessageType(PurchaseMessageTypeEnum messageType) {
		this.messageType = messageType;
	}


	
}
