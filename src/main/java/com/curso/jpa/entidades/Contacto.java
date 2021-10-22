
package com.curso.jpa.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author begonaolea
 */
@Entity
@Table(name = "CONTACTOS")
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c"),
    @NamedQuery(name = "Contacto.findById", query = "SELECT c FROM Contacto c WHERE c.id = :id"),
    @NamedQuery(name = "Contacto.findByNombre", query = "SELECT c FROM Contacto c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Contacto.findByApellidos", query = "SELECT c FROM Contacto c WHERE c.apellidos = :apellidos"),
    @NamedQuery(name = "Contacto.findByEmail", query = "SELECT c FROM Contacto c WHERE c.email = :email"),
    @NamedQuery(name = "Contacto.findByFechaNac", query = "SELECT c FROM Contacto c WHERE c.fechaNac = :fechaNac")})
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "APELLIDOS")
    private String apellidos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NAC")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    
    
    
    
    @JoinTable(name = "GRUPOS_CONTACTOS", joinColumns = {
        @JoinColumn(name = "ID_CONTACTO", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_GRUPO", referencedColumnName = "ID")})
    @ManyToMany
    private Set<Grupo> grupoSet;
    

    public Contacto() {
    }

    public Contacto(Integer id) {
        this.id = id;
    }

    public Contacto(Integer id, String nombre, String apellidos, String email, Date fechaNac) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fechaNac = fechaNac;
        this.grupoSet = new HashSet<Grupo>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Set<Grupo> getGrupoSet() {
        return grupoSet;
    }

    public void setGrupoSet(Set<Grupo> grupoSet) {
        this.grupoSet = grupoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.jpa.entidades.Contacto[ id=" + id + " ]";
    }
    
}
