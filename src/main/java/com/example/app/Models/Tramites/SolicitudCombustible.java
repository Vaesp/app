package com.example.app.Models.Tramites;

import com.example.app.Models.Area;
import com.example.app.Models.Municipio;
import com.example.app.Models.Vehiculo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitudCombustible", uniqueConstraints = {
        @UniqueConstraint(columnNames = "folio")
})
public class SolicitudCombustible {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String folio;

    private LocalDate fecha;

    private String solicitante;

    private String motivo;

    private Long kmInicial;

    private Long kmPorRecorrer;

    private Long kmFinal;

    private String nivelActual;

    private Double montoAutorizado;

    private String jefeSolicitante;

    private String jefeMateriales;

    private String jefeUnidadAdministrativa;

    private LocalDateTime timestamp;

    private LocalDateTime timestampEdit;

    private String userstamp;

    @ManyToOne
    private Municipio municipio;

    @ManyToOne
    private TipoSolicitud tipoSolicitud;

    @ManyToOne
    private Area area;

    @ManyToOne
    private Vehiculo vehiculo;



    public SolicitudCombustible() {
    }

    public SolicitudCombustible(Long id, String folio, LocalDate fecha, String solicitante, String motivo, Long kmInicial, Long kmPorRecorrer, Long kmFinal, String nivelActual, Double montoAutorizado, String jefeSolicitante, String jefeMateriales, String jefeUnidadAdministrativa, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp, Municipio municipio, TipoSolicitud tipoSolicitud, Area area, Vehiculo vehiculo) {
        this.id = id;
        this.folio = folio;
        this.fecha = fecha;
        this.solicitante = solicitante;
        this.motivo = motivo;
        this.kmInicial = kmInicial;
        this.kmPorRecorrer = kmPorRecorrer;
        this.kmFinal = kmFinal;
        this.nivelActual = nivelActual;
        this.montoAutorizado = montoAutorizado;
        this.jefeSolicitante = jefeSolicitante;
        this.jefeMateriales = jefeMateriales;
        this.jefeUnidadAdministrativa = jefeUnidadAdministrativa;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
        this.municipio = municipio;
        this.tipoSolicitud = tipoSolicitud;
        this.area = area;
        this.vehiculo = vehiculo;
    }

    public SolicitudCombustible(String folio, LocalDate fecha, String solicitante, String motivo, Long kmInicial, Long kmPorRecorrer, Long kmFinal, String nivelActual, Double montoAutorizado, String jefeSolicitante, String jefeMateriales, String jefeUnidadAdministrativa, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp, Municipio municipio, TipoSolicitud tipoSolicitud, Area area, Vehiculo vehiculo) {
        this.folio = folio;
        this.fecha = fecha;
        this.solicitante = solicitante;
        this.motivo = motivo;
        this.kmInicial = kmInicial;
        this.kmPorRecorrer = kmPorRecorrer;
        this.kmFinal = kmFinal;
        this.nivelActual = nivelActual;
        this.montoAutorizado = montoAutorizado;
        this.jefeSolicitante = jefeSolicitante;
        this.jefeMateriales = jefeMateriales;
        this.jefeUnidadAdministrativa = jefeUnidadAdministrativa;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
        this.municipio = municipio;
        this.tipoSolicitud = tipoSolicitud;
        this.area = area;
        this.vehiculo = vehiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Long getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(Long kmInicial) {
        this.kmInicial = kmInicial;
    }

    public Long getKmPorRecorrer() {
        return kmPorRecorrer;
    }

    public void setKmPorRecorrer(Long kmPorRecorrer) {
        this.kmPorRecorrer = kmPorRecorrer;
    }

    public Long getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(Long kmFinal) {
        this.kmFinal = kmFinal;
    }

    public String getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(String nivelActual) {
        this.nivelActual = nivelActual;
    }

    public Double getMontoAutorizado() {
        return montoAutorizado;
    }

    public void setMontoAutorizado(Double montoAutorizado) {
        this.montoAutorizado = montoAutorizado;
    }

    public String getJefeSolicitante() {
        return jefeSolicitante;
    }

    public void setJefeSolicitante(String jefeSolicitante) {
        this.jefeSolicitante = jefeSolicitante;
    }

    public String getJefeMateriales() {
        return jefeMateriales;
    }

    public void setJefeMateriales(String jefeMateriales) {
        this.jefeMateriales = jefeMateriales;
    }

    public String getJefeUnidadAdministrativa() {
        return jefeUnidadAdministrativa;
    }

    public void setJefeUnidadAdministrativa(String jefeUnidadAdministrativa) {
        this.jefeUnidadAdministrativa = jefeUnidadAdministrativa;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestampEdit() {
        return timestampEdit;
    }

    public void setTimestampEdit(LocalDateTime timestampEdit) {
        this.timestampEdit = timestampEdit;
    }

    public String getUserstamp() {
        return userstamp;
    }

    public void setUserstamp(String userstamp) {
        this.userstamp = userstamp;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public TipoSolicitud getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
