package es.fjtorres.pruebas.juan.ejemplo.persistencia.modelo;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
@Table(name = "PERSONS")
public class Person extends AbstractModel {

   private static final long serialVersionUID = 5967579424208596564L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(name = "FIRST_NAME", nullable = false, length = 255)
   private String firstName;

   @Column(name = "LAST_NAME", nullable = false, length = 255)
   private String lastName;

   @Column(name = "BIRTHDAY", nullable = false, length = 255)
   @Temporal(TemporalType.DATE)
   private Date birthday;

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(final String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(final String lastName) {
      this.lastName = lastName;
   }

   public Date getBirthday() {
      return birthday;
   }

   public void setBirthday(final Date birthday) {
      this.birthday = birthday;
   }

   @Override
   public int hashCode() {
      return Objects.hash(getBirthday(), getFirstName(), getLastName());
   }

   @Override
   public boolean equals(final Object obj) {
      boolean isEquals = false;

      if (obj instanceof Person) {
         final Person other = (Person) obj;
         final EqualsBuilder builder = new EqualsBuilder();
         builder.append(getBirthday(), other.getBirthday()).append(
               getFirstName(), other.getFirstName()).append(getLastName(),
               other.getLastName());
      }

      return isEquals;
   }

   @Override
   public Long getId() {
      return id;
   }

   @Override
   public void setId(final Long id) {
      this.id = id;
   }

}
