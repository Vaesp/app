package com.example.app.Models.Tramites;

import com.example.app.Models.Area;
import com.example.app.Models.Municipio;
import com.example.app.Models.Vehiculo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "resguardoTemporal", uniqueConstraints = {
        @UniqueConstraint(columnNames = "folio")
})
public class ResguardoTemporal {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String folio;

    private String solicitante;

    private Boolean comodatario;

    private String noOficio;

    private String motivo;

    private LocalDate fechaSalida;

    private LocalDate fechaLlegada;

    private Long kmSalida;

    private Long kmLlegada;

    private String observacionesSalida;

    private String observacionesLlegada;

    private Boolean antenaRadioS;

    private Boolean plumasParabrisasS;

    private Boolean llantaRefaccionS;

    private Boolean taponGasolinaS;

    private Boolean taponAceiteS;

    private Boolean placaDelanteraS;

    private Boolean placaTraseraS;

    private Boolean espejoDerechoS;

    private Boolean espejoIzquierdoS;

    private Boolean taponesLlantaS;

    private Boolean antenaVHFS;

    private Boolean herramientaS;

    private Boolean reflejantesS;

    private Boolean aireAcondicionadoS;

    private Boolean extintorS;

    private Boolean gatoS;

    private Boolean polizaSeguroS;

    private Boolean calcomaniaVerificacionS;

    private Boolean juegoLlavesS;

    private Boolean tarjetaCirculacionS;

    private Boolean licenciaManejoS;

    private Boolean bolaArrastreS;

    private Boolean antenaRadioL;

    private Boolean plumasParabrisasL;

    private Boolean llantaRefaccionL;

    private Boolean taponGasolinaL;

    private Boolean taponAceiteL;

    private Boolean placaDelanteraL;

    private Boolean placaTraseraL;

    private Boolean espejoDerechoL;

    private Boolean espejoIzquierdoL;

    private Boolean taponesLlantaL;

    private Boolean antenaVHFL;

    private Boolean herramientaL;

    private Boolean reflejantesL;

    private Boolean aireAcondicionadoL;

    private Boolean extintorL;

    private Boolean gatoL;

    private Boolean polizaSeguroL;

    private Boolean calcomaniaVerificacionL;

    private Boolean juegoLlavesL;

    private Boolean tarjetaCirculacionL;

    private Boolean licenciaManejoL;

    private Boolean bolaArrastreL;

    private String nivelFrenosS;

    private String nivelFrenosL;

    private String nivelAceiteS;

    private String nivelAceiteL;

    private String nivelAnticongelanteS;

    private String nivelAnticongelanteL;

    private String nivelGasolinaS;

    private String nivelGasolinaL;

    private LocalDateTime timestamp;

    private LocalDateTime timestampEdit;

    private String userstamp;

    @ManyToOne
    private EstatusTramite estatusTramite;

    @ManyToOne
    private Vehiculo vehiculo;

    @ManyToOne
    private Area area;

    @ManyToOne
    private Municipio municipio;

    public ResguardoTemporal() {
    }

    public ResguardoTemporal(Long id, String folio, String solicitante, Boolean comodatario, String noOficio, String motivo, LocalDate fechaSalida, LocalDate fechaLlegada, Long kmSalida, Long kmLlegada, String observacionesSalida, String observacionesLlegada, Boolean antenaRadioS, Boolean plumasParabrisasS, Boolean llantaRefaccionS, Boolean taponGasolinaS, Boolean taponAceiteS, Boolean placaDelanteraS, Boolean placaTraseraS, Boolean espejoDerechoS, Boolean espejoIzquierdoS, Boolean taponesLlantaS, Boolean antenaVHFS, Boolean herramientaS, Boolean reflejantesS, Boolean aireAcondicionadoS, Boolean extintorS, Boolean gatoS, Boolean polizaSeguroS, Boolean calcomaniaVerificacionS, Boolean juegoLlavesS, Boolean tarjetaCirculacionS, Boolean licenciaManejoS, Boolean bolaArrastreS, Boolean antenaRadioL, Boolean plumasParabrisasL, Boolean llantaRefaccionL, Boolean taponGasolinaL, Boolean taponAceiteL, Boolean placaDelanteraL, Boolean placaTraseraL, Boolean espejoDerechoL, Boolean espejoIzquierdoL, Boolean taponesLlantaL, Boolean antenaVHFL, Boolean herramientaL, Boolean reflejantesL, Boolean aireAcondicionadoL, Boolean extintorL, Boolean gatoL, Boolean polizaSeguroL, Boolean calcomaniaVerificacionL, Boolean juegoLlavesL, Boolean tarjetaCirculacionL, Boolean licenciaManejoL, Boolean bolaArrastreL, String nivelFrenosS, String nivelFrenosL, String nivelAceiteS, String nivelAceiteL, String nivelAnticongelanteS, String nivelAnticongelanteL, String nivelGasolinaS, String nivelGasolinaL, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp, EstatusTramite estatusTramite, Vehiculo vehiculo, Area area, Municipio municipio) {
        this.id = id;
        this.folio = folio;
        this.solicitante = solicitante;
        this.comodatario = comodatario;
        this.noOficio = noOficio;
        this.motivo = motivo;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.kmSalida = kmSalida;
        this.kmLlegada = kmLlegada;
        this.observacionesSalida = observacionesSalida;
        this.observacionesLlegada = observacionesLlegada;
        this.antenaRadioS = antenaRadioS;
        this.plumasParabrisasS = plumasParabrisasS;
        this.llantaRefaccionS = llantaRefaccionS;
        this.taponGasolinaS = taponGasolinaS;
        this.taponAceiteS = taponAceiteS;
        this.placaDelanteraS = placaDelanteraS;
        this.placaTraseraS = placaTraseraS;
        this.espejoDerechoS = espejoDerechoS;
        this.espejoIzquierdoS = espejoIzquierdoS;
        this.taponesLlantaS = taponesLlantaS;
        this.antenaVHFS = antenaVHFS;
        this.herramientaS = herramientaS;
        this.reflejantesS = reflejantesS;
        this.aireAcondicionadoS = aireAcondicionadoS;
        this.extintorS = extintorS;
        this.gatoS = gatoS;
        this.polizaSeguroS = polizaSeguroS;
        this.calcomaniaVerificacionS = calcomaniaVerificacionS;
        this.juegoLlavesS = juegoLlavesS;
        this.tarjetaCirculacionS = tarjetaCirculacionS;
        this.licenciaManejoS = licenciaManejoS;
        this.bolaArrastreS = bolaArrastreS;
        this.antenaRadioL = antenaRadioL;
        this.plumasParabrisasL = plumasParabrisasL;
        this.llantaRefaccionL = llantaRefaccionL;
        this.taponGasolinaL = taponGasolinaL;
        this.taponAceiteL = taponAceiteL;
        this.placaDelanteraL = placaDelanteraL;
        this.placaTraseraL = placaTraseraL;
        this.espejoDerechoL = espejoDerechoL;
        this.espejoIzquierdoL = espejoIzquierdoL;
        this.taponesLlantaL = taponesLlantaL;
        this.antenaVHFL = antenaVHFL;
        this.herramientaL = herramientaL;
        this.reflejantesL = reflejantesL;
        this.aireAcondicionadoL = aireAcondicionadoL;
        this.extintorL = extintorL;
        this.gatoL = gatoL;
        this.polizaSeguroL = polizaSeguroL;
        this.calcomaniaVerificacionL = calcomaniaVerificacionL;
        this.juegoLlavesL = juegoLlavesL;
        this.tarjetaCirculacionL = tarjetaCirculacionL;
        this.licenciaManejoL = licenciaManejoL;
        this.bolaArrastreL = bolaArrastreL;
        this.nivelFrenosS = nivelFrenosS;
        this.nivelFrenosL = nivelFrenosL;
        this.nivelAceiteS = nivelAceiteS;
        this.nivelAceiteL = nivelAceiteL;
        this.nivelAnticongelanteS = nivelAnticongelanteS;
        this.nivelAnticongelanteL = nivelAnticongelanteL;
        this.nivelGasolinaS = nivelGasolinaS;
        this.nivelGasolinaL = nivelGasolinaL;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
        this.estatusTramite = estatusTramite;
        this.vehiculo = vehiculo;
        this.area = area;
        this.municipio = municipio;
    }

    public ResguardoTemporal(String folio, String solicitante, Boolean comodatario, String noOficio, String motivo, LocalDate fechaSalida, LocalDate fechaLlegada, Long kmSalida, Long kmLlegada, String observacionesSalida, String observacionesLlegada, Boolean antenaRadioS, Boolean plumasParabrisasS, Boolean llantaRefaccionS, Boolean taponGasolinaS, Boolean taponAceiteS, Boolean placaDelanteraS, Boolean placaTraseraS, Boolean espejoDerechoS, Boolean espejoIzquierdoS, Boolean taponesLlantaS, Boolean antenaVHFS, Boolean herramientaS, Boolean reflejantesS, Boolean aireAcondicionadoS, Boolean extintorS, Boolean gatoS, Boolean polizaSeguroS, Boolean calcomaniaVerificacionS, Boolean juegoLlavesS, Boolean tarjetaCirculacionS, Boolean licenciaManejoS, Boolean bolaArrastreS, Boolean antenaRadioL, Boolean plumasParabrisasL, Boolean llantaRefaccionL, Boolean taponGasolinaL, Boolean taponAceiteL, Boolean placaDelanteraL, Boolean placaTraseraL, Boolean espejoDerechoL, Boolean espejoIzquierdoL, Boolean taponesLlantaL, Boolean antenaVHFL, Boolean herramientaL, Boolean reflejantesL, Boolean aireAcondicionadoL, Boolean extintorL, Boolean gatoL, Boolean polizaSeguroL, Boolean calcomaniaVerificacionL, Boolean juegoLlavesL, Boolean tarjetaCirculacionL, Boolean licenciaManejoL, Boolean bolaArrastreL, String nivelFrenosS, String nivelFrenosL, String nivelAceiteS, String nivelAceiteL, String nivelAnticongelanteS, String nivelAnticongelanteL, String nivelGasolinaS, String nivelGasolinaL, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp, EstatusTramite estatusTramite, Vehiculo vehiculo, Area area, Municipio municipio) {
        this.folio = folio;
        this.solicitante = solicitante;
        this.comodatario = comodatario;
        this.noOficio = noOficio;
        this.motivo = motivo;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.kmSalida = kmSalida;
        this.kmLlegada = kmLlegada;
        this.observacionesSalida = observacionesSalida;
        this.observacionesLlegada = observacionesLlegada;
        this.antenaRadioS = antenaRadioS;
        this.plumasParabrisasS = plumasParabrisasS;
        this.llantaRefaccionS = llantaRefaccionS;
        this.taponGasolinaS = taponGasolinaS;
        this.taponAceiteS = taponAceiteS;
        this.placaDelanteraS = placaDelanteraS;
        this.placaTraseraS = placaTraseraS;
        this.espejoDerechoS = espejoDerechoS;
        this.espejoIzquierdoS = espejoIzquierdoS;
        this.taponesLlantaS = taponesLlantaS;
        this.antenaVHFS = antenaVHFS;
        this.herramientaS = herramientaS;
        this.reflejantesS = reflejantesS;
        this.aireAcondicionadoS = aireAcondicionadoS;
        this.extintorS = extintorS;
        this.gatoS = gatoS;
        this.polizaSeguroS = polizaSeguroS;
        this.calcomaniaVerificacionS = calcomaniaVerificacionS;
        this.juegoLlavesS = juegoLlavesS;
        this.tarjetaCirculacionS = tarjetaCirculacionS;
        this.licenciaManejoS = licenciaManejoS;
        this.bolaArrastreS = bolaArrastreS;
        this.antenaRadioL = antenaRadioL;
        this.plumasParabrisasL = plumasParabrisasL;
        this.llantaRefaccionL = llantaRefaccionL;
        this.taponGasolinaL = taponGasolinaL;
        this.taponAceiteL = taponAceiteL;
        this.placaDelanteraL = placaDelanteraL;
        this.placaTraseraL = placaTraseraL;
        this.espejoDerechoL = espejoDerechoL;
        this.espejoIzquierdoL = espejoIzquierdoL;
        this.taponesLlantaL = taponesLlantaL;
        this.antenaVHFL = antenaVHFL;
        this.herramientaL = herramientaL;
        this.reflejantesL = reflejantesL;
        this.aireAcondicionadoL = aireAcondicionadoL;
        this.extintorL = extintorL;
        this.gatoL = gatoL;
        this.polizaSeguroL = polizaSeguroL;
        this.calcomaniaVerificacionL = calcomaniaVerificacionL;
        this.juegoLlavesL = juegoLlavesL;
        this.tarjetaCirculacionL = tarjetaCirculacionL;
        this.licenciaManejoL = licenciaManejoL;
        this.bolaArrastreL = bolaArrastreL;
        this.nivelFrenosS = nivelFrenosS;
        this.nivelFrenosL = nivelFrenosL;
        this.nivelAceiteS = nivelAceiteS;
        this.nivelAceiteL = nivelAceiteL;
        this.nivelAnticongelanteS = nivelAnticongelanteS;
        this.nivelAnticongelanteL = nivelAnticongelanteL;
        this.nivelGasolinaS = nivelGasolinaS;
        this.nivelGasolinaL = nivelGasolinaL;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
        this.estatusTramite = estatusTramite;
        this.vehiculo = vehiculo;
        this.area = area;
        this.municipio = municipio;
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

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public Boolean getComodatario() {
        return comodatario;
    }

    public void setComodatario(Boolean comodatario) {
        this.comodatario = comodatario;
    }

    public String getNoOficio() {
        return noOficio;
    }

    public void setNoOficio(String noOficio) {
        this.noOficio = noOficio;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Long getKmSalida() {
        return kmSalida;
    }

    public void setKmSalida(Long kmSalida) {
        this.kmSalida = kmSalida;
    }

    public Long getKmLlegada() {
        return kmLlegada;
    }

    public void setKmLlegada(Long kmLlegada) {
        this.kmLlegada = kmLlegada;
    }

    public String getObservacionesSalida() {
        return observacionesSalida;
    }

    public void setObservacionesSalida(String observacionesSalida) {
        this.observacionesSalida = observacionesSalida;
    }

    public String getObservacionesLlegada() {
        return observacionesLlegada;
    }

    public void setObservacionesLlegada(String observacionesLlegada) {
        this.observacionesLlegada = observacionesLlegada;
    }

    public Boolean getAntenaRadioS() {
        return antenaRadioS;
    }

    public void setAntenaRadioS(Boolean antenaRadioS) {
        this.antenaRadioS = antenaRadioS;
    }

    public Boolean getPlumasParabrisasS() {
        return plumasParabrisasS;
    }

    public void setPlumasParabrisasS(Boolean plumasParabrisasS) {
        this.plumasParabrisasS = plumasParabrisasS;
    }

    public Boolean getLlantaRefaccionS() {
        return llantaRefaccionS;
    }

    public void setLlantaRefaccionS(Boolean llantaRefaccionS) {
        this.llantaRefaccionS = llantaRefaccionS;
    }

    public Boolean getTaponGasolinaS() {
        return taponGasolinaS;
    }

    public void setTaponGasolinaS(Boolean taponGasolinaS) {
        this.taponGasolinaS = taponGasolinaS;
    }

    public Boolean getTaponAceiteS() {
        return taponAceiteS;
    }

    public void setTaponAceiteS(Boolean taponAceiteS) {
        this.taponAceiteS = taponAceiteS;
    }

    public Boolean getPlacaDelanteraS() {
        return placaDelanteraS;
    }

    public void setPlacaDelanteraS(Boolean placaDelanteraS) {
        this.placaDelanteraS = placaDelanteraS;
    }

    public Boolean getPlacaTraseraS() {
        return placaTraseraS;
    }

    public void setPlacaTraseraS(Boolean placaTraseraS) {
        this.placaTraseraS = placaTraseraS;
    }

    public Boolean getEspejoDerechoS() {
        return espejoDerechoS;
    }

    public void setEspejoDerechoS(Boolean espejoDerechoS) {
        this.espejoDerechoS = espejoDerechoS;
    }

    public Boolean getEspejoIzquierdoS() {
        return espejoIzquierdoS;
    }

    public void setEspejoIzquierdoS(Boolean espejoIzquierdoS) {
        this.espejoIzquierdoS = espejoIzquierdoS;
    }

    public Boolean getTaponesLlantaS() {
        return taponesLlantaS;
    }

    public void setTaponesLlantaS(Boolean taponesLlantaS) {
        this.taponesLlantaS = taponesLlantaS;
    }

    public Boolean getAntenaVHFS() {
        return antenaVHFS;
    }

    public void setAntenaVHFS(Boolean antenaVHFS) {
        this.antenaVHFS = antenaVHFS;
    }

    public Boolean getHerramientaS() {
        return herramientaS;
    }

    public void setHerramientaS(Boolean herramientaS) {
        this.herramientaS = herramientaS;
    }

    public Boolean getReflejantesS() {
        return reflejantesS;
    }

    public void setReflejantesS(Boolean reflejantesS) {
        this.reflejantesS = reflejantesS;
    }

    public Boolean getAireAcondicionadoS() {
        return aireAcondicionadoS;
    }

    public void setAireAcondicionadoS(Boolean aireAcondicionadoS) {
        this.aireAcondicionadoS = aireAcondicionadoS;
    }

    public Boolean getExtintorS() {
        return extintorS;
    }

    public void setExtintorS(Boolean extintorS) {
        this.extintorS = extintorS;
    }

    public Boolean getGatoS() {
        return gatoS;
    }

    public void setGatoS(Boolean gatoS) {
        this.gatoS = gatoS;
    }

    public Boolean getPolizaSeguroS() {
        return polizaSeguroS;
    }

    public void setPolizaSeguroS(Boolean polizaSeguroS) {
        this.polizaSeguroS = polizaSeguroS;
    }

    public Boolean getCalcomaniaVerificacionS() {
        return calcomaniaVerificacionS;
    }

    public void setCalcomaniaVerificacionS(Boolean calcomaniaVerificacionS) {
        this.calcomaniaVerificacionS = calcomaniaVerificacionS;
    }

    public Boolean getJuegoLlavesS() {
        return juegoLlavesS;
    }

    public void setJuegoLlavesS(Boolean juegoLlavesS) {
        this.juegoLlavesS = juegoLlavesS;
    }

    public Boolean getTarjetaCirculacionS() {
        return tarjetaCirculacionS;
    }

    public void setTarjetaCirculacionS(Boolean tarjetaCirculacionS) {
        this.tarjetaCirculacionS = tarjetaCirculacionS;
    }

    public Boolean getLicenciaManejoS() {
        return licenciaManejoS;
    }

    public void setLicenciaManejoS(Boolean licenciaManejoS) {
        this.licenciaManejoS = licenciaManejoS;
    }

    public Boolean getBolaArrastreS() {
        return bolaArrastreS;
    }

    public void setBolaArrastreS(Boolean bolaArrastreS) {
        this.bolaArrastreS = bolaArrastreS;
    }

    public Boolean getAntenaRadioL() {
        return antenaRadioL;
    }

    public void setAntenaRadioL(Boolean antenaRadioL) {
        this.antenaRadioL = antenaRadioL;
    }

    public Boolean getPlumasParabrisasL() {
        return plumasParabrisasL;
    }

    public void setPlumasParabrisasL(Boolean plumasParabrisasL) {
        this.plumasParabrisasL = plumasParabrisasL;
    }

    public Boolean getLlantaRefaccionL() {
        return llantaRefaccionL;
    }

    public void setLlantaRefaccionL(Boolean llantaRefaccionL) {
        this.llantaRefaccionL = llantaRefaccionL;
    }

    public Boolean getTaponGasolinaL() {
        return taponGasolinaL;
    }

    public void setTaponGasolinaL(Boolean taponGasolinaL) {
        this.taponGasolinaL = taponGasolinaL;
    }

    public Boolean getTaponAceiteL() {
        return taponAceiteL;
    }

    public void setTaponAceiteL(Boolean taponAceiteL) {
        this.taponAceiteL = taponAceiteL;
    }

    public Boolean getPlacaDelanteraL() {
        return placaDelanteraL;
    }

    public void setPlacaDelanteraL(Boolean placaDelanteraL) {
        this.placaDelanteraL = placaDelanteraL;
    }

    public Boolean getPlacaTraseraL() {
        return placaTraseraL;
    }

    public void setPlacaTraseraL(Boolean placaTraseraL) {
        this.placaTraseraL = placaTraseraL;
    }

    public Boolean getEspejoDerechoL() {
        return espejoDerechoL;
    }

    public void setEspejoDerechoL(Boolean espejoDerechoL) {
        this.espejoDerechoL = espejoDerechoL;
    }

    public Boolean getEspejoIzquierdoL() {
        return espejoIzquierdoL;
    }

    public void setEspejoIzquierdoL(Boolean espejoIzquierdoL) {
        this.espejoIzquierdoL = espejoIzquierdoL;
    }

    public Boolean getTaponesLlantaL() {
        return taponesLlantaL;
    }

    public void setTaponesLlantaL(Boolean taponesLlantaL) {
        this.taponesLlantaL = taponesLlantaL;
    }

    public Boolean getAntenaVHFL() {
        return antenaVHFL;
    }

    public void setAntenaVHFL(Boolean antenaVHFL) {
        this.antenaVHFL = antenaVHFL;
    }

    public Boolean getHerramientaL() {
        return herramientaL;
    }

    public void setHerramientaL(Boolean herramientaL) {
        this.herramientaL = herramientaL;
    }

    public Boolean getReflejantesL() {
        return reflejantesL;
    }

    public void setReflejantesL(Boolean reflejantesL) {
        this.reflejantesL = reflejantesL;
    }

    public Boolean getAireAcondicionadoL() {
        return aireAcondicionadoL;
    }

    public void setAireAcondicionadoL(Boolean aireAcondicionadoL) {
        this.aireAcondicionadoL = aireAcondicionadoL;
    }

    public Boolean getExtintorL() {
        return extintorL;
    }

    public void setExtintorL(Boolean extintorL) {
        this.extintorL = extintorL;
    }

    public Boolean getGatoL() {
        return gatoL;
    }

    public void setGatoL(Boolean gatoL) {
        this.gatoL = gatoL;
    }

    public Boolean getPolizaSeguroL() {
        return polizaSeguroL;
    }

    public void setPolizaSeguroL(Boolean polizaSeguroL) {
        this.polizaSeguroL = polizaSeguroL;
    }

    public Boolean getCalcomaniaVerificacionL() {
        return calcomaniaVerificacionL;
    }

    public void setCalcomaniaVerificacionL(Boolean calcomaniaVerificacionL) {
        this.calcomaniaVerificacionL = calcomaniaVerificacionL;
    }

    public Boolean getJuegoLlavesL() {
        return juegoLlavesL;
    }

    public void setJuegoLlavesL(Boolean juegoLlavesL) {
        this.juegoLlavesL = juegoLlavesL;
    }

    public Boolean getTarjetaCirculacionL() {
        return tarjetaCirculacionL;
    }

    public void setTarjetaCirculacionL(Boolean tarjetaCirculacionL) {
        this.tarjetaCirculacionL = tarjetaCirculacionL;
    }

    public Boolean getLicenciaManejoL() {
        return licenciaManejoL;
    }

    public void setLicenciaManejoL(Boolean licenciaManejoL) {
        this.licenciaManejoL = licenciaManejoL;
    }

    public Boolean getBolaArrastreL() {
        return bolaArrastreL;
    }

    public void setBolaArrastreL(Boolean bolaArrastreL) {
        this.bolaArrastreL = bolaArrastreL;
    }

    public String getNivelFrenosS() {
        return nivelFrenosS;
    }

    public void setNivelFrenosS(String nivelFrenosS) {
        this.nivelFrenosS = nivelFrenosS;
    }

    public String getNivelFrenosL() {
        return nivelFrenosL;
    }

    public void setNivelFrenosL(String nivelFrenosL) {
        this.nivelFrenosL = nivelFrenosL;
    }

    public String getNivelAceiteS() {
        return nivelAceiteS;
    }

    public void setNivelAceiteS(String nivelAceiteS) {
        this.nivelAceiteS = nivelAceiteS;
    }

    public String getNivelAceiteL() {
        return nivelAceiteL;
    }

    public void setNivelAceiteL(String nivelAceiteL) {
        this.nivelAceiteL = nivelAceiteL;
    }

    public String getNivelAnticongelanteS() {
        return nivelAnticongelanteS;
    }

    public void setNivelAnticongelanteS(String nivelAnticongelanteS) {
        this.nivelAnticongelanteS = nivelAnticongelanteS;
    }

    public String getNivelAnticongelanteL() {
        return nivelAnticongelanteL;
    }

    public void setNivelAnticongelanteL(String nivelAnticongelanteL) {
        this.nivelAnticongelanteL = nivelAnticongelanteL;
    }

    public String getNivelGasolinaS() {
        return nivelGasolinaS;
    }

    public void setNivelGasolinaS(String nivelGasolinaS) {
        this.nivelGasolinaS = nivelGasolinaS;
    }

    public String getNivelGasolinaL() {
        return nivelGasolinaL;
    }

    public void setNivelGasolinaL(String nivelGasolinaL) {
        this.nivelGasolinaL = nivelGasolinaL;
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

    public EstatusTramite getEstatusTramite() {
        return estatusTramite;
    }

    public void setEstatusTramite(EstatusTramite estatusTramite) {
        this.estatusTramite = estatusTramite;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
