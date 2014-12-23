package es.fjtorres.pruebas.juan.ejemplo.persistencia.modelo;

import java.io.Serializable;

public class TestModel implements Serializable {

   private static final long serialVersionUID = -8487522744325374786L;

   private String text;

   private Integer number;

   public String getText() {
      return text;
   }

   public void setText(final String text) {
      this.text = text;
   }

   public Integer getNumber() {
      return number;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }
}
