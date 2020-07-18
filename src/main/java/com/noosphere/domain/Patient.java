package com.noosphere.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A Patient.
 */
@Entity
@Table(name = "patient")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "fullname", nullable = false)
    private String fullname;

    @NotNull
    @Column(name = "date_birthday", nullable = false)
    private LocalDate dateBirthday;

    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @Pattern(regexp = "+380[0-9]{9}")
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotNull
    @Column(name = "diagnosis", nullable = false)
    private Integer diagnosis;

    @OneToMany(mappedBy = "patient")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Visit> visits = new HashSet<>();

    @OneToMany(mappedBy = "patient")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<History> histories = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public Patient fullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getDateBirthday() {
        return dateBirthday;
    }

    public Patient dateBirthday(LocalDate dateBirthday) {
        this.dateBirthday = dateBirthday;
        return this;
    }

    public void setDateBirthday(LocalDate dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public String getAddress() {
        return address;
    }

    public Patient address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public Patient phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDiagnosis() {
        return diagnosis;
    }

    public Patient diagnosis(Integer diagnosis) {
        this.diagnosis = diagnosis;
        return this;
    }

    public void setDiagnosis(Integer diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public Patient visits(Set<Visit> visits) {
        this.visits = visits;
        return this;
    }

    public Patient addVisit(Visit visit) {
        this.visits.add(visit);
        visit.setPatient(this);
        return this;
    }

    public Patient removeVisit(Visit visit) {
        this.visits.remove(visit);
        visit.setPatient(null);
        return this;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    public Set<History> getHistories() {
        return histories;
    }

    public Patient histories(Set<History> histories) {
        this.histories = histories;
        return this;
    }

    public Patient addHistory(History history) {
        this.histories.add(history);
        history.setPatient(this);
        return this;
    }

    public Patient removeHistory(History history) {
        this.histories.remove(history);
        history.setPatient(null);
        return this;
    }

    public void setHistories(Set<History> histories) {
        this.histories = histories;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Patient)) {
            return false;
        }
        return id != null && id.equals(((Patient) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Patient{" +
            "id=" + getId() +
            ", fullname='" + getFullname() + "'" +
            ", dateBirthday='" + getDateBirthday() + "'" +
            ", address='" + getAddress() + "'" +
            ", phone='" + getPhone() + "'" +
            ", diagnosis=" + getDiagnosis() +
            "}";
    }
}
