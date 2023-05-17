package com.example.app.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "vehiculo",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "noEconomico")
        })
public class Vehiculo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String noEconomico;

    private String marca;

    private String tipoVehiculo;

    private Integer modelo;

    private String color;

    private Integer cilindraje;

    private Double capacidadTanque;

    @ManyToOne
    private UnidadTanque unidadTanque;


    private String tipoNeumaticos;

    private String placasAnteriores;

    private String placas;

    private Integer ultimoDigito;

    private String noMotor;

    private String noSerie;

    private String noFactura;

    private String noTarjetaCirculacion;

    private String observaciones;

    private String noCasco;

    private String noMatricula;

    private String nombreAseguradora;

    private String telefonoAseguradora;

    private String noPoliza;

    private LocalDate fechaContratacion;

    private LocalDate fechaRenovacion;

    private String noPoliza2;

    private LocalDate fechaContratacion2;

    private LocalDate fechaRenovacion2;

    private Integer kilometraje;

    private Long horasUso;

    private LocalDateTime timestamp;

    private LocalDateTime timestampEdit;

    private String userstamp;

    private LocalDate proximoMantenimiento;

    private LocalDate proximoCambioNeumaticos;

    private String ubicacion;

    private String detalleEstatusVehiculo;

    private String noExpediente;

    private String uso;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Municipio municipio;

    @ManyToOne
    private TipoCombustible tipoCombustible;

    @ManyToOne
    private Area area;

    @ManyToOne
    private Resguardante resguardante;

    @ManyToOne
    private EstatusVehiculo estatusVehiculo;

    @ManyToOne
    private EstatusCarroceria estatusCarroceria;

    @ManyToOne
    private EstatusDocumental estatusDocumental;


    public Vehiculo() {
    }

    public Vehiculo(Long id, String noEconomico, String marca, String tipoVehiculo, Integer modelo, String color, Integer cilindraje, Double capacidadTanque, UnidadTanque unidadTanque, String tipoNeumaticos, String placasAnteriores, String placas, Integer ultimoDigito, String noMotor, String noSerie, String noFactura, String noTarjetaCirculacion, String observaciones, String noCasco, String noMatricula, String nombreAseguradora, String telefonoAseguradora, String noPoliza, LocalDate fechaContratacion, LocalDate fechaRenovacion, String noPoliza2, LocalDate fechaContratacion2, LocalDate fechaRenovacion2, Integer kilometraje, Long horasUso, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp, LocalDate proximoMantenimiento, LocalDate proximoCambioNeumaticos, String ubicacion, String detalleEstatusVehiculo, String noExpediente, String uso, Categoria categoria, Municipio municipio, TipoCombustible tipoCombustible, Area area, Resguardante resguardante, EstatusVehiculo estatusVehiculo, EstatusCarroceria estatusCarroceria, EstatusDocumental estatusDocumental) {
        this.id = id;
        this.noEconomico = noEconomico;
        this.marca = marca;
        this.tipoVehiculo = tipoVehiculo;
        this.modelo = modelo;
        this.color = color;
        this.cilindraje = cilindraje;
        this.capacidadTanque = capacidadTanque;
        this.unidadTanque = unidadTanque;
        this.tipoNeumaticos = tipoNeumaticos;
        this.placasAnteriores = placasAnteriores;
        this.placas = placas;
        this.ultimoDigito = ultimoDigito;
        this.noMotor = noMotor;
        this.noSerie = noSerie;
        this.noFactura = noFactura;
        this.noTarjetaCirculacion = noTarjetaCirculacion;
        this.observaciones = observaciones;
        this.noCasco = noCasco;
        this.noMatricula = noMatricula;
        this.nombreAseguradora = nombreAseguradora;
        this.telefonoAseguradora = telefonoAseguradora;
        this.noPoliza = noPoliza;
        this.fechaContratacion = fechaContratacion;
        this.fechaRenovacion = fechaRenovacion;
        this.noPoliza2 = noPoliza2;
        this.fechaContratacion2 = fechaContratacion2;
        this.fechaRenovacion2 = fechaRenovacion2;
        this.kilometraje = kilometraje;
        this.horasUso = horasUso;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
        this.proximoMantenimiento = proximoMantenimiento;
        this.proximoCambioNeumaticos = proximoCambioNeumaticos;
        this.ubicacion = ubicacion;
        this.detalleEstatusVehiculo = detalleEstatusVehiculo;
        this.noExpediente = noExpediente;
        this.uso = uso;
        this.categoria = categoria;
        this.municipio = municipio;
        this.tipoCombustible = tipoCombustible;
        this.area = area;
        this.resguardante = resguardante;
        this.estatusVehiculo = estatusVehiculo;
        this.estatusCarroceria = estatusCarroceria;
        this.estatusDocumental = estatusDocumental;
    }

    public Vehiculo(String noEconomico, String marca, String tipoVehiculo, Integer modelo, String color, Integer cilindraje, Double capacidadTanque, UnidadTanque unidadTanque, String tipoNeumaticos, String placasAnteriores, String placas, Integer ultimoDigito, String noMotor, String noSerie, String noFactura, String noTarjetaCirculacion, String observaciones, String noCasco, String noMatricula, String nombreAseguradora, String telefonoAseguradora, String noPoliza, LocalDate fechaContratacion, LocalDate fechaRenovacion, String noPoliza2, LocalDate fechaContratacion2, LocalDate fechaRenovacion2, Integer kilometraje, Long horasUso, LocalDateTime timestamp, LocalDateTime timestampEdit, String userstamp, LocalDate proximoMantenimiento, LocalDate proximoCambioNeumaticos, String ubicacion, String detalleEstatusVehiculo, String noExpediente, String uso, Categoria categoria, Municipio municipio, TipoCombustible tipoCombustible, Area area, Resguardante resguardante, EstatusVehiculo estatusVehiculo, EstatusCarroceria estatusCarroceria, EstatusDocumental estatusDocumental) {
        this.noEconomico = noEconomico;
        this.marca = marca;
        this.tipoVehiculo = tipoVehiculo;
        this.modelo = modelo;
        this.color = color;
        this.cilindraje = cilindraje;
        this.capacidadTanque = capacidadTanque;
        this.unidadTanque = unidadTanque;
        this.tipoNeumaticos = tipoNeumaticos;
        this.placasAnteriores = placasAnteriores;
        this.placas = placas;
        this.ultimoDigito = ultimoDigito;
        this.noMotor = noMotor;
        this.noSerie = noSerie;
        this.noFactura = noFactura;
        this.noTarjetaCirculacion = noTarjetaCirculacion;
        this.observaciones = observaciones;
        this.noCasco = noCasco;
        this.noMatricula = noMatricula;
        this.nombreAseguradora = nombreAseguradora;
        this.telefonoAseguradora = telefonoAseguradora;
        this.noPoliza = noPoliza;
        this.fechaContratacion = fechaContratacion;
        this.fechaRenovacion = fechaRenovacion;
        this.noPoliza2 = noPoliza2;
        this.fechaContratacion2 = fechaContratacion2;
        this.fechaRenovacion2 = fechaRenovacion2;
        this.kilometraje = kilometraje;
        this.horasUso = horasUso;
        this.timestamp = timestamp;
        this.timestampEdit = timestampEdit;
        this.userstamp = userstamp;
        this.proximoMantenimiento = proximoMantenimiento;
        this.proximoCambioNeumaticos = proximoCambioNeumaticos;
        this.ubicacion = ubicacion;
        this.detalleEstatusVehiculo = detalleEstatusVehiculo;
        this.noExpediente = noExpediente;
        this.uso = uso;
        this.categoria = categoria;
        this.municipio = municipio;
        this.tipoCombustible = tipoCombustible;
        this.area = area;
        this.resguardante = resguardante;
        this.estatusVehiculo = estatusVehiculo;
        this.estatusCarroceria = estatusCarroceria;
        this.estatusDocumental = estatusDocumental;
    }

    public Vehiculo(String noEconomico, String marca, String tipoVehiculo, Integer modelo, String color, Integer cilindraje, String placasAnteriores, String placas, String noMotor, String noSerie, String noTarjetaCirculacion, Integer kilometraje, LocalDateTime timestamp, String userstamp, String ubicacion, String detalleEstatusVehiculo, String noExpediente, String uso, Categoria categoria, Municipio municipio, Area area, Resguardante resguardante, EstatusVehiculo estatusVehiculo, EstatusCarroceria estatusCarroceria, EstatusDocumental estatusDocumental) {
        this.noEconomico = noEconomico;
        this.marca = marca;
        this.tipoVehiculo = tipoVehiculo;
        this.modelo = modelo;
        this.color = color;
        this.cilindraje = cilindraje;
        this.placasAnteriores = placasAnteriores;
        this.placas = placas;
        if (!(placas == null) && !(Objects.equals(placas, ""))) {
            try {
                String placasNumber = placas.replaceAll("[^0-9]", "");
                String lastNumber = placasNumber.substring(placasNumber.length() - 1);
                this.ultimoDigito = Integer.parseInt(lastNumber);
            } catch (Exception e) {
                this.ultimoDigito = null;
            }
        }
        this.noMotor = noMotor;
        this.noSerie = noSerie;
        this.noTarjetaCirculacion = noTarjetaCirculacion;
        this.kilometraje = kilometraje;
        this.timestamp = timestamp;
        this.userstamp = userstamp;
        this.ubicacion = ubicacion;
        this.detalleEstatusVehiculo = detalleEstatusVehiculo;
        this.noExpediente = noExpediente;
        this.uso = uso;
        this.categoria = categoria;
        this.municipio = municipio;
        this.area = area;
        this.resguardante = resguardante;
        this.estatusVehiculo = estatusVehiculo;
        this.estatusCarroceria = estatusCarroceria;
        this.estatusDocumental = estatusDocumental;
    }

    public String getDetalleEstatusVehiculo() {
        return detalleEstatusVehiculo;
    }

    public void setDetalleEstatusVehiculo(String detalleEstatusVehiculo) {
        this.detalleEstatusVehiculo = detalleEstatusVehiculo;
    }

    public String getNoExpediente() {
        return noExpediente;
    }

    public void setNoExpediente(String noExpediente) {
        this.noExpediente = noExpediente;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public EstatusCarroceria getEstatusCarroceria() {
        return estatusCarroceria;
    }

    public void setEstatusCarroceria(EstatusCarroceria estatusCarroceria) {
        this.estatusCarroceria = estatusCarroceria;
    }

    public EstatusDocumental getEstatusDocumental() {
        return estatusDocumental;
    }

    public void setEstatusDocumental(EstatusDocumental estatusDocumental) {
        this.estatusDocumental = estatusDocumental;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoEconomico() {
        return noEconomico;
    }

    public void setNoEconomico(String noEconomico) {
        this.noEconomico = noEconomico;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Integer cilindraje) {
        this.cilindraje = cilindraje;
    }

    public Double getCapacidadTanque() {
        return capacidadTanque;
    }

    public void setCapacidadTanque(Double capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
    }

    public UnidadTanque getUnidadTanque() {
        return unidadTanque;
    }

    public void setUnidadTanque(UnidadTanque unidadTanque) {
        this.unidadTanque = unidadTanque;
    }

    public String getTipoNeumaticos() {
        return tipoNeumaticos;
    }

    public void setTipoNeumaticos(String tipoNeumaticos) {
        this.tipoNeumaticos = tipoNeumaticos;
    }

    public String getPlacasAnteriores() {
        return placasAnteriores;
    }

    public void setPlacasAnteriores(String placasAnteriores) {
        this.placasAnteriores = placasAnteriores;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public Integer getUltimoDigito() {
        return ultimoDigito;
    }

    public void setUltimoDigito() {
        String placas = getPlacas();
        if (!(placas == null) && !(Objects.equals(placas, ""))) {
            try {
                String placasNumber = placas.replaceAll("[^0-9]", "");
                String lastNumber = placasNumber.substring(placasNumber.length() - 1);
                this.ultimoDigito = Integer.parseInt(lastNumber);
            } catch (Exception e) {
                this.ultimoDigito = null;
            }
        }
    }

    public String getNoMotor() {
        return noMotor;
    }

    public void setNoMotor(String noMotor) {
        this.noMotor = noMotor;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public String getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(String noFactura) {
        this.noFactura = noFactura;
    }

    public String getNoTarjetaCirculacion() {
        return noTarjetaCirculacion;
    }

    public void setNoTarjetaCirculacion(String noTarjetaCirculacion) {
        this.noTarjetaCirculacion = noTarjetaCirculacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNoCasco() {
        return noCasco;
    }

    public void setNoCasco(String noCasco) {
        this.noCasco = noCasco;
    }

    public String getNoMatricula() {
        return noMatricula;
    }

    public void setNoMatricula(String noMatricula) {
        this.noMatricula = noMatricula;
    }

    public String getNombreAseguradora() {
        return nombreAseguradora;
    }

    public void setNombreAseguradora(String nombreAseguradora) {
        this.nombreAseguradora = nombreAseguradora;
    }

    public String getTelefonoAseguradora() {
        return telefonoAseguradora;
    }

    public void setTelefonoAseguradora(String telefonoAseguradora) {
        this.telefonoAseguradora = telefonoAseguradora;
    }

    public String getNoPoliza() {
        return noPoliza;
    }

    public void setNoPoliza(String noPoliza) {
        this.noPoliza = noPoliza;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public LocalDate getFechaRenovacion() {
        return fechaRenovacion;
    }

    public void setFechaRenovacion(LocalDate fechaRenovacion) {
        this.fechaRenovacion = fechaRenovacion;
    }

    public String getNoPoliza2() {
        return noPoliza2;
    }

    public void setNoPoliza2(String noPoliza2) {
        this.noPoliza2 = noPoliza2;
    }

    public LocalDate getFechaContratacion2() {
        return fechaContratacion2;
    }

    public void setFechaContratacion2(LocalDate fechaContratacion2) {
        this.fechaContratacion2 = fechaContratacion2;
    }

    public LocalDate getFechaRenovacion2() {
        return fechaRenovacion2;
    }

    public void setFechaRenovacion2(LocalDate fechaRenovacion2) {
        this.fechaRenovacion2 = fechaRenovacion2;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Long getHorasUso() {
        return horasUso;
    }

    public void setHorasUso(Long horasUso) {
        this.horasUso = horasUso;
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

    public LocalDate getProximoMantenimiento() {
        return proximoMantenimiento;
    }

    public void setProximoMantenimiento(LocalDate proximoMantenimiento) {
        this.proximoMantenimiento = proximoMantenimiento;
    }

    public LocalDate getProximoCambioNeumaticos() {
        return proximoCambioNeumaticos;
    }

    public void setProximoCambioNeumaticos(LocalDate proximoCambioNeumaticos) {
        this.proximoCambioNeumaticos = proximoCambioNeumaticos;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Resguardante getResguardante() {
        return resguardante;
    }

    public void setResguardante(Resguardante resguardante) {
        this.resguardante = resguardante;
    }

    public EstatusVehiculo getEstatusVehiculo() {
        return estatusVehiculo;
    }

    public void setEstatusVehiculo(EstatusVehiculo estatusVehiculo) {
        this.estatusVehiculo = estatusVehiculo;
    }
}