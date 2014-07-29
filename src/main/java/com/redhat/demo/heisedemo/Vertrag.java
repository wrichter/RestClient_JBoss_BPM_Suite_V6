package com.redhat.demo.heisedemo;

public class Vertrag implements java.io.Serializable {
	
	static final long serialVersionUID = 1L;

	    private java.lang.Double amount;	
	    private java.lang.Integer rabatt;
	    private java.lang.String type;
	    private java.lang.String vertriebskanal;

	    public Vertrag() {
	    }

	    public Vertrag(java.lang.Double amount, java.lang.Integer rabatt, java.lang.String type, java.lang.String vertriebskanal) {
	        this.amount = amount;
	        this.rabatt = rabatt;
	        this.type = type;
	        this.vertriebskanal = vertriebskanal;
	    }

		public java.lang.Double getAmount() {
			return amount;
		}

		public void setAmount(java.lang.Double amount) {
			this.amount = amount;
		}

		public java.lang.Integer getRabatt() {
			return rabatt;
		}

		public void setRabatt(java.lang.Integer rabatt) {
			this.rabatt = rabatt;
		}

		public java.lang.String getType() {
			return type;
		}

		public void setType(java.lang.String type) {
			this.type = type;
		}

		public java.lang.String getVertriebskanal() {
			return vertriebskanal;
		}

		public void setVertriebskanal(java.lang.String vertriebskanal) {
			this.vertriebskanal = vertriebskanal;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

	}