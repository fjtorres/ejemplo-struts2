package es.fjtorres.pruebas.juan.ejemplo.persistencia.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import es.fjtorres.pruebas.juan.ejemplo.persistencia.servicio.impl.AuditEntityListener;

@MappedSuperclass
@EntityListeners({
   AuditEntityListener.class
})
public abstract class AbstractModel implements Serializable {

   private static final long serialVersionUID = 6530970429269788697L;

   @Version
   private long version;

   @Temporal(TemporalType.TIMESTAMP)
   private Date creationDate;

   @Temporal(TemporalType.TIMESTAMP)
   private Date modificationDate;

   public abstract Long getId();

   public abstract void setId(final Long id);

   public long getVersion() {
      return version;
   }

   public void setVersion(final long version) {
      this.version = version;
   }

   public Date getCreationDate() {
      return creationDate;
   }

   public void setCreationDate(final Date creationDate) {
      this.creationDate = creationDate;
   }

   public Date getModificationDate() {
      return modificationDate;
   }

   public void setModificationDate(final Date modificationDate) {
      this.modificationDate = modificationDate;
   }
}
