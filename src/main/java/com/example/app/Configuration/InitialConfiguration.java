package com.example.app.Configuration;

import com.example.app.Models.*;
import com.example.app.Models.Tramites.EstatusTramite;
import com.example.app.Models.Tramites.PeriodoVerificacion;
import com.example.app.Models.Tramites.TipoMantenimiento;
import com.example.app.Models.Tramites.TipoSolicitud;
import com.example.app.Repositories.*;
import com.example.app.Repositories.Tramites.EstatusTramiteRepository;
import com.example.app.Repositories.Tramites.PeriodoVerificacionRepository;
import com.example.app.Repositories.Tramites.TipoMantenimientoRepository;
import com.example.app.Repositories.Tramites.TipoSolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class InitialConfiguration {
    @Autowired
    AreaRepository areaRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    EstatusVehiculoRepository estatusVehiculoRepository;
    @Autowired
    MunicipioRepository municipioRepository;
    @Autowired
    ResguardanteRepository resguardanteRepository;
    @Autowired
    TipoTransporteRepository tipoTransporteRepository;

    @Autowired
    ContadorRepository contadorRepository;

    @Autowired
    EstatusCarroceriaRepository estatusCarroceriaRepository;

    @Autowired
    EstatusDocumentalRepository estatusDocumentalRepository;

    @Bean("Municipio")
    CommandLineRunner commandLineRunner(MunicipioRepository municipioRepository) {
        if (municipioRepository.count() != 212) {
            System.out.println(LocalDateTime.now() + " - Inicializando Municipios...");
            municipioRepository.deleteAll();
            return args -> {
                Municipio m1 = new Municipio(1L, "Acajete");
                Municipio m2 = new Municipio(2L, "Acatlán");
                Municipio m3 = new Municipio(3L, "Acayucan");
                Municipio m4 = new Municipio(4L, "Actopan");
                Municipio m5 = new Municipio(5L, "Acula");
                Municipio m6 = new Municipio(6L, "Acultzingo");
                Municipio m7 = new Municipio(7L, "Camarón de Tejeda");
                Municipio m8 = new Municipio(8L, "Alpatlahuac");
                Municipio m9 = new Municipio(9L, "Alto Lucero de Gutiérrez Barrios");
                Municipio m10 = new Municipio(10L, "Altotonga");
                Municipio m11 = new Municipio(11L, "Alvarado");
                Municipio m12 = new Municipio(12L, "Amatitlán");
                Municipio m13 = new Municipio(13L, "Naranjos Amatlán");
                Municipio m14 = new Municipio(14L, "Amatlán de los Reyes");
                Municipio m15 = new Municipio(15L, "Ángel R. Cabada");
                Municipio m16 = new Municipio(16L, "La Antigua");
                Municipio m17 = new Municipio(17L, "Apazapan");
                Municipio m18 = new Municipio(18L, "Aquila");
                Municipio m19 = new Municipio(19L, "Astacinga");
                Municipio m20 = new Municipio(20L, "Atlahuilco");
                Municipio m21 = new Municipio(21L, "Atoyac");
                Municipio m22 = new Municipio(22L, "Atzacan");
                Municipio m23 = new Municipio(23L, "Atzalan");
                Municipio m24 = new Municipio(24L, "Tlaltetela");
                Municipio m25 = new Municipio(25L, "Ayahualulco");
                Municipio m26 = new Municipio(26L, "Banderilla");
                Municipio m27 = new Municipio(27L, "Benito Juárez");
                Municipio m28 = new Municipio(28L, "Boca del Río");
                Municipio m29 = new Municipio(29L, "Calcahualco");
                Municipio m30 = new Municipio(30L, "Camerino Z. Mendoza");
                Municipio m31 = new Municipio(31L, "Carrilo Puerto");
                Municipio m32 = new Municipio(32L, "Catemaco");
                Municipio m33 = new Municipio(33L, "Cazones de Herrera");
                Municipio m34 = new Municipio(34L, "Cerro Azul");
                Municipio m35 = new Municipio(35L, "Citlaltépetl");
                Municipio m36 = new Municipio(36L, "Coacoatzintla");
                Municipio m37 = new Municipio(37L, "Coahuitlán");
                Municipio m38 = new Municipio(38L, "Coatepec");
                Municipio m39 = new Municipio(39L, "Coatzacoalcos");
                Municipio m40 = new Municipio(40L, "Coatzintla");
                Municipio m41 = new Municipio(41L, "Coetzala");
                Municipio m42 = new Municipio(42L, "Colipa");
                Municipio m43 = new Municipio(43L, "Comapa");
                Municipio m44 = new Municipio(44L, "Córdoba");
                Municipio m45 = new Municipio(45L, "Cosamaloapan de Carpio");
                Municipio m46 = new Municipio(46L, "Cosautlán de Carvajal");
                Municipio m47 = new Municipio(47L, "Coscomatepec");
                Municipio m48 = new Municipio(48L, "Cosoleacaque");
                Municipio m49 = new Municipio(49L, "Cotaxtla");
                Municipio m50 = new Municipio(50L, "Coxquihui");
                Municipio m51 = new Municipio(51L, "Coyutla");
                Municipio m52 = new Municipio(52L, "Cuichapa");
                Municipio m53 = new Municipio(53L, "Cuitláhuac");
                Municipio m54 = new Municipio(54L, "Chacaltianguis");
                Municipio m55 = new Municipio(55L, "Chalma");
                Municipio m56 = new Municipio(56L, "Chiconamel");
                Municipio m57 = new Municipio(57L, "Chiconquiaco");
                Municipio m58 = new Municipio(58L, "Chicontepec");
                Municipio m59 = new Municipio(59L, "Chinameca");
                Municipio m60 = new Municipio(60L, "Chinampa de Gorostiza");
                Municipio m61 = new Municipio(61L, "Las Choapas");
                Municipio m62 = new Municipio(62L, "Chocamán");
                Municipio m63 = new Municipio(63L, "Chontla");
                Municipio m64 = new Municipio(64L, "Chumatlán");
                Municipio m65 = new Municipio(65L, "Emiliano Zapata");
                Municipio m66 = new Municipio(66L, "Espinal");
                Municipio m67 = new Municipio(67L, "Filomeno Mata");
                Municipio m68 = new Municipio(68L, "Fortín");
                Municipio m69 = new Municipio(69L, "Gutiérrez Zamora");
                Municipio m70 = new Municipio(70L, "Hidalgotitlán");
                Municipio m71 = new Municipio(71L, "Huatusco");
                Municipio m72 = new Municipio(72L, "Huayacocotla");
                Municipio m73 = new Municipio(73L, "Hueyapan de Ocampo");
                Municipio m74 = new Municipio(74L, "Huiloapan de Cuauhtémoc");
                Municipio m75 = new Municipio(75L, "Ignacio de la Llave");
                Municipio m76 = new Municipio(76L, "Ilamatlán");
                Municipio m77 = new Municipio(77L, "Isla");
                Municipio m78 = new Municipio(78L, "Ixcatepec");
                Municipio m79 = new Municipio(79L, "Ixhuacán de los Reyes");
                Municipio m80 = new Municipio(80L, "Ixhuatlán del Café");
                Municipio m81 = new Municipio(81L, "Ixhuatlancillo");
                Municipio m82 = new Municipio(82L, "Ixhuatlán del Sureste");
                Municipio m83 = new Municipio(83L, "Ixhuatlán de Madero");
                Municipio m84 = new Municipio(84L, "Ixmatlahuacan");
                Municipio m85 = new Municipio(85L, "Ixtaczoquitlán");
                Municipio m86 = new Municipio(86L, "Jalacingo");
                Municipio m87 = new Municipio(87L, "Xalapa");
                Municipio m88 = new Municipio(88L, "Jalcomulco");
                Municipio m89 = new Municipio(89L, "Jáltipan");
                Municipio m90 = new Municipio(90L, "Jamapa");
                Municipio m91 = new Municipio(91L, "Jesús Carranza");
                Municipio m92 = new Municipio(92L, "Xico");
                Municipio m93 = new Municipio(93L, "Jilotepec");
                Municipio m94 = new Municipio(94L, "Juan Rodríguez Clara");
                Municipio m95 = new Municipio(95L, "Juchique de Ferrer");
                Municipio m96 = new Municipio(96L, "Landero y Coss");
                Municipio m97 = new Municipio(97L, "Lerdo de Tejada");
                Municipio m98 = new Municipio(98L, "Magdalena");
                Municipio m99 = new Municipio(99L, "Maltrata");
                Municipio m100 = new Municipio(100L, "Manlio Fabio Altamirano");
                Municipio m101 = new Municipio(101L, "Mariano Escobedo");
                Municipio m102 = new Municipio(102L, "Martínez de la Torre");
                Municipio m103 = new Municipio(103L, "Mecatlán");
                Municipio m104 = new Municipio(104L, "Mecayapan");
                Municipio m105 = new Municipio(105L, "Medellín de Bravo");
                Municipio m106 = new Municipio(106L, "Miahuatlan");
                Municipio m107 = new Municipio(107L, "Las Minas");
                Municipio m108 = new Municipio(108L, "Minatitlán");
                Municipio m109 = new Municipio(109L, "Misantla");
                Municipio m110 = new Municipio(110L, "Mixtla de Altamirano");
                Municipio m111 = new Municipio(111L, "Moloacán");
                Municipio m112 = new Municipio(112L, "Naolinco");
                Municipio m113 = new Municipio(113L, "Naranjal");
                Municipio m114 = new Municipio(114L, "Nautla");
                Municipio m115 = new Municipio(115L, "Nogales");
                Municipio m116 = new Municipio(116L, "Oluta");
                Municipio m117 = new Municipio(117L, "Omealca");
                Municipio m118 = new Municipio(118L, "Orizaba");
                Municipio m119 = new Municipio(119L, "Otatitlán");
                Municipio m120 = new Municipio(120L, "Oteapan");
                Municipio m121 = new Municipio(121L, "Ozuluama de Mascareñas");
                Municipio m122 = new Municipio(122L, "Pajapan");
                Municipio m123 = new Municipio(123L, "Pánuco");
                Municipio m124 = new Municipio(124L, "Papantla");
                Municipio m125 = new Municipio(125L, "Paso del Macho");
                Municipio m126 = new Municipio(126L, "Paso de Ovejas");
                Municipio m127 = new Municipio(127L, "La Perla");
                Municipio m128 = new Municipio(128L, "Perote");
                Municipio m129 = new Municipio(129L, "Platón Sánchez");
                Municipio m130 = new Municipio(130L, "Playa Vicente");
                Municipio m131 = new Municipio(131L, "Poza Rica de Hidalgo");
                Municipio m132 = new Municipio(132L, "Las Vigas de Ramírez");
                Municipio m133 = new Municipio(133L, "Pueblo Viejo");
                Municipio m134 = new Municipio(134L, "Puente Nacional");
                Municipio m135 = new Municipio(135L, "Rafael Delgado");
                Municipio m136 = new Municipio(136L, "Rafael Lucio");
                Municipio m137 = new Municipio(137L, "Los Reyes");
                Municipio m138 = new Municipio(138L, "Río Blanco");
                Municipio m139 = new Municipio(139L, "Saltabarranca");
                Municipio m140 = new Municipio(140L, "San Andrés Tenejapan");
                Municipio m141 = new Municipio(141L, "San Andrés Tuxtla");
                Municipio m142 = new Municipio(142L, "San Juan Evangelista");
                Municipio m143 = new Municipio(143L, "Santiago Tuxtla");
                Municipio m144 = new Municipio(144L, "Sayula de Alemán");
                Municipio m145 = new Municipio(145L, "Soconusco");
                Municipio m146 = new Municipio(146L, "Sochiapan");
                Municipio m147 = new Municipio(147L, "Soledad Atzompa");
                Municipio m148 = new Municipio(148L, "Soledad de Doblado");
                Municipio m149 = new Municipio(149L, "Soteapan");
                Municipio m150 = new Municipio(150L, "Tamalín");
                Municipio m151 = new Municipio(151L, "Tamiahua");
                Municipio m152 = new Municipio(152L, "Tampico Alto");
                Municipio m153 = new Municipio(153L, "Tancoco");
                Municipio m154 = new Municipio(154L, "Tantima");
                Municipio m155 = new Municipio(155L, "Tantoyuca");
                Municipio m156 = new Municipio(156L, "Tatatila");
                Municipio m157 = new Municipio(157L, "Castillo de Teayo");
                Municipio m158 = new Municipio(158L, "Tecolutla");
                Municipio m159 = new Municipio(159L, "Tehuipango");
                Municipio m160 = new Municipio(160L, "Álamo Tempache");
                Municipio m161 = new Municipio(161L, "Tempoal");
                Municipio m162 = new Municipio(162L, "Tenampa");
                Municipio m163 = new Municipio(163L, "Tenochtitlán");
                Municipio m164 = new Municipio(164L, "Teocelo");
                Municipio m165 = new Municipio(165L, "Tepatlaxco");
                Municipio m166 = new Municipio(166L, "Tepetlán");
                Municipio m167 = new Municipio(167L, "Tepetzintla");
                Municipio m168 = new Municipio(168L, "Tequila");
                Municipio m169 = new Municipio(169L, "José Azueta");
                Municipio m170 = new Municipio(170L, "Texcatepec");
                Municipio m171 = new Municipio(171L, "Texhuacán");
                Municipio m172 = new Municipio(172L, "Texistepec");
                Municipio m173 = new Municipio(173L, "Tezonapa");
                Municipio m174 = new Municipio(174L, "Tierra Blanca");
                Municipio m175 = new Municipio(175L, "Tihuatlán");
                Municipio m176 = new Municipio(176L, "Tlacojalpan");
                Municipio m177 = new Municipio(177L, "Tlacolulan");
                Municipio m178 = new Municipio(178L, "Tlacotalpan");
                Municipio m179 = new Municipio(179L, "Tlacoltepec de Mejía");
                Municipio m180 = new Municipio(180L, "Tlachichilco");
                Municipio m181 = new Municipio(181L, "Tlalixcoyan");
                Municipio m182 = new Municipio(182L, "Tlalnelhuayocan");
                Municipio m183 = new Municipio(183L, "Tlapacoyan");
                Municipio m184 = new Municipio(184L, "Tlaquilpa");
                Municipio m185 = new Municipio(185L, "Tlilapan");
                Municipio m186 = new Municipio(186L, "Tomatlán");
                Municipio m187 = new Municipio(187L, "Tonayán");
                Municipio m188 = new Municipio(188L, "Totutla");
                Municipio m189 = new Municipio(189L, "Tuxpan");
                Municipio m190 = new Municipio(190L, "Tuxtilla");
                Municipio m191 = new Municipio(191L, "Ursulo Galván");
                Municipio m192 = new Municipio(192L, "Vega de Alatorre");
                Municipio m193 = new Municipio(193L, "Veracruz");
                Municipio m194 = new Municipio(194L, "Villa Aldama");
                Municipio m195 = new Municipio(195L, "Xoxocotla");
                Municipio m196 = new Municipio(196L, "Yanga");
                Municipio m197 = new Municipio(197L, "Yecuatla");
                Municipio m198 = new Municipio(198L, "Zacualpan");
                Municipio m199 = new Municipio(199L, "Zaragoza");
                Municipio m200 = new Municipio(200L, "Zentla");
                Municipio m201 = new Municipio(201L, "Zongolica");
                Municipio m202 = new Municipio(202L, "Zontecomatlán de López y Fuentes");
                Municipio m203 = new Municipio(203L, "Zozocolco de Hidalgo");
                Municipio m204 = new Municipio(204L, "Agua Dulce");
                Municipio m205 = new Municipio(205L, "El Higo");
                Municipio m206 = new Municipio(206L, "Nanchital de Lázaro Cárdenas del Río");
                Municipio m207 = new Municipio(207L, "Tres Valles");
                Municipio m208 = new Municipio(208L, "Carlos A. Carrillo");
                Municipio m209 = new Municipio(209L, "Tatahuicapan de Juárez");
                Municipio m210 = new Municipio(210L, "Uxpanapa");
                Municipio m211 = new Municipio(211L, "San Rafael");
                Municipio m212 = new Municipio(212L, "Santiago Sochiapan");

                municipioRepository.saveAll(
                        List.of(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16, m17, m18, m19, m20, m21, m22, m23, m24, m25, m26, m27, m28, m29, m30, m31, m32, m33, m34, m35, m36, m37, m38, m39, m40, m41, m42, m43, m44, m45, m46, m47, m48, m49, m50,
                                m51, m52, m53, m54, m55, m56, m57, m58, m59, m60, m61, m62, m63, m64, m65, m66, m67, m68, m69, m70, m71, m72, m73, m74, m75, m76, m77, m78, m79, m80, m81, m82, m83, m84, m85, m86, m87, m88, m89, m90, m91, m92, m93, m94, m95, m96, m97, m98, m99, m100,
                                m101, m102, m103, m104, m105, m106, m107, m108, m109, m110, m111, m112, m113, m114, m115, m116, m117, m118, m119, m120, m121, m122, m123, m124, m125, m126, m127, m128, m129, m130, m131, m132, m133, m134, m135, m136, m137, m138, m139, m140, m141, m142, m143, m144, m145, m146, m147, m148, m149, m150,
                                m151, m152, m153, m154, m155, m156, m157, m158, m159, m160, m161, m162, m163, m164, m165, m166, m167, m168, m169, m170, m171, m172, m173, m174, m175, m176, m177, m178, m179, m180, m181, m182, m183, m184, m185, m186, m187, m188, m189, m190, m191, m192, m193, m194, m195, m196, m197, m198, m199, m200,
                                m201, m202, m203, m204, m205, m206, m207, m208, m209, m210, m211, m212)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - Municipios: COMPLETOS");
        return null;
    }

    @Bean("TipoTransporte")
    CommandLineRunner commandLineRunner(TipoTransporteRepository tipoTransporteRepository) {
        if (tipoTransporteRepository.count() != 2) {
            System.out.println(LocalDateTime.now() + " - Inicializando TipoTransporte...");
            tipoTransporteRepository.deleteAll();
            return args -> {
                TipoTransporte t1 = new TipoTransporte(1L, "Terrestre", "-");
                TipoTransporte t2 = new TipoTransporte(2L, "Embarcación", "_");

                tipoTransporteRepository.saveAll(
                        List.of(t1, t2)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - TipoTransporte: COMPLETOS");
        return null;
    }

    @Bean("Categoria")
    CommandLineRunner commandLineRunner(CategoriaRepository categoriaRepository) {
        if (categoriaRepository.count() != 7) {
            System.out.println(LocalDateTime.now() + " - Inicializando Categoria...");
            categoriaRepository.deleteAll();
            return args -> {
                Categoria ca1 = new Categoria(1L, "Ataque rápido", tipoTransporteRepository.getById(1L));
                Categoria ca2 = new Categoria(2L, "Caja seca", tipoTransporteRepository.getById(1L));
                Categoria ca3 = new Categoria(3L, "Coche", tipoTransporteRepository.getById(1L));
                Categoria ca4 = new Categoria(4L, "Cuatrimoto", tipoTransporteRepository.getById(1L));
                Categoria ca5 = new Categoria(5L, "PickUp", tipoTransporteRepository.getById(1L));
                Categoria ca6 = new Categoria(6L, "Pipa", tipoTransporteRepository.getById(1L));
                Categoria ca7 = new Categoria(7L, "Lancha", tipoTransporteRepository.getById(2L));

                categoriaRepository.saveAll(
                        List.of(ca1, ca2, ca3, ca4, ca5, ca6, ca7)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - Categoria: COMPLETOS");
        return null;
    }

    @Bean("EstatusVehiculo")
    CommandLineRunner commandLineRunner(EstatusVehiculoRepository estatusVehiculoRepository) {
        if (estatusVehiculoRepository.count() != 2) {
            System.out.println(LocalDateTime.now() + " - Inicializando EstatusVehiculo...");
            estatusVehiculoRepository.deleteAll();
            return args -> {
                EstatusVehiculo e1 = new EstatusVehiculo(1L, "Activo");
                EstatusVehiculo e2 = new EstatusVehiculo(2L, "Inactivo");

                estatusVehiculoRepository.saveAll(
                        List.of(e1, e2)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - EstatusVehiculo: COMPLETOS");
        return null;
    }

    @Bean("TipoCombustible")
    CommandLineRunner commandLineRunner(TipoCombustibleRepository tipoCombustibleRepository) {
        if (tipoCombustibleRepository.count() != 2) {
            System.out.println(LocalDateTime.now() + " - Inicializando TipoCombustible...");
            tipoCombustibleRepository.deleteAll();
            return args -> {
                TipoCombustible c1 = new TipoCombustible(1L, "Gasolina");
                TipoCombustible c2 = new TipoCombustible(2L, "Diésel");

                tipoCombustibleRepository.saveAll(
                        List.of(c1, c2)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - TipoCombustible: COMPLETOS");
        return null;
    }

    @Bean("EstatusTramite")
    CommandLineRunner commandLineRunner(EstatusTramiteRepository estatusTramiteRepository) {
        if (estatusTramiteRepository.count() != 2) {
            System.out.println(LocalDateTime.now() + " - Inicializando EstatusTramite...");
            estatusTramiteRepository.deleteAll();
            return args -> {
                EstatusTramite t1 = new EstatusTramite(1L, "Concluido");
                EstatusTramite t2 = new EstatusTramite(2L, "En proceso");

                estatusTramiteRepository.saveAll(
                        List.of(t1, t2)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - EstatusTramite: COMPLETOS");
        return null;
    }

    @Bean("TipoMantenimiento")
    CommandLineRunner commandLineRunner(TipoMantenimientoRepository tipoMantenimientoRepository) {
        if (tipoMantenimientoRepository.count() != 2) {
            System.out.println(LocalDateTime.now() + " - Inicializando TipoMantenimiento...");
            tipoMantenimientoRepository.deleteAll();
            return args -> {
                TipoMantenimiento m1 = new TipoMantenimiento(1L, "Preventivo");
                TipoMantenimiento m2 = new TipoMantenimiento(2L, "Correctivo");

                tipoMantenimientoRepository.saveAll(
                        List.of(m1, m2)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - TipoMantenimiento: COMPLETOS");
        return null;
    }

    @Bean("TipoSolicitud")
    CommandLineRunner commandLineRunner(TipoSolicitudRepository tipoSolicitudRepository) {
        if (tipoSolicitudRepository.count() != 2) {
            System.out.println(LocalDateTime.now() + " - Inicializando TipoSolicitud...");
            tipoSolicitudRepository.deleteAll();
            return args -> {
                TipoSolicitud s1 = new TipoSolicitud(1L, "Comisión");
                TipoSolicitud s2 = new TipoSolicitud(2L, "Recarga");

                tipoSolicitudRepository.saveAll(
                        List.of(s1, s2)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - TipoSolicitud: COMPLETOS");
        return null;
    }

    @Bean("UnidadTanque")
    CommandLineRunner commandLineRunner(UnidadTanqueRepository unidadTanqueRepository) {
        if (unidadTanqueRepository.count() != 2) {
            System.out.println(LocalDateTime.now() + " - Inicializando UnidadTanque...");
            unidadTanqueRepository.deleteAll();
            return args -> {
                UnidadTanque u1 = new UnidadTanque(1L, "L");
                UnidadTanque u2 = new UnidadTanque(2L, "Gal");
                unidadTanqueRepository.saveAll(
                        List.of(u1, u2)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - UnidadTanque: COMPLETOS");
        return null;
    }

    @Bean("PeriodoVerificacion")
    CommandLineRunner commandLineRunner(PeriodoVerificacionRepository periodoVerificacionRepository) {
        if (periodoVerificacionRepository.count() != 2) {
            System.out.println(LocalDateTime.now() + " - Inicializando PeriodoVerificacion...");
            periodoVerificacionRepository.deleteAll();
            return args -> {
                PeriodoVerificacion p1 = new PeriodoVerificacion(1L, "Primer periodo");
                PeriodoVerificacion p2 = new PeriodoVerificacion(2L, "Segundo periodo");

                periodoVerificacionRepository.saveAll(
                        List.of(p1, p2)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - PeriodoVerifiacion: COMPLETOS");
        return null;
    }

    @Bean("EstatusCarroceria")
    CommandLineRunner commandLineRunner(EstatusCarroceriaRepository estatusCarroceriaRepository) {
        if (estatusCarroceriaRepository.count() != 3) {
            System.out.println(LocalDateTime.now() + " - Inicializando EstatusCarroceria...");
            estatusCarroceriaRepository.deleteAll();
            return args -> {
                EstatusCarroceria c1 = new EstatusCarroceria(1L, "Bueno");
                EstatusCarroceria c2 = new EstatusCarroceria(2L, "Malo");
                EstatusCarroceria c3 = new EstatusCarroceria(3L, "Regular");

                estatusCarroceriaRepository.saveAll(
                        List.of(c1, c2, c3)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - EstatusCarroceria: COMPLETOS");
        return null;
    }

    @Bean("EstatusDocumental")
    CommandLineRunner commandLineRunner(EstatusDocumentalRepository estatusDocumentalRepository) {
        if (estatusDocumentalRepository.count() != 2) {
            System.out.println(LocalDateTime.now() + " - Inicializando EstatusDocumental...");
            estatusDocumentalRepository.deleteAll();
            return args -> {
                EstatusDocumental d1 = new EstatusDocumental(1L, "Regular");
                EstatusDocumental d2 = new EstatusDocumental(2L, "Irregular");

                estatusDocumentalRepository.saveAll(
                        List.of(d1, d2)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - EstatusDocumental: COMPLETOS");
        return null;
    }

    @Bean("Area")
    CommandLineRunner commandLineRunner(AreaRepository areaRepository) {
        if (areaRepository.count() == 0) {
            System.out.println(LocalDateTime.now() + " - Inicializando Area...");
            areaRepository.deleteAll();
            return args -> {
                Area a1 = new Area("Unidad Administrativa", "Mtra. Aurora Alejandra Cervantes Hernández", LocalDateTime.now().withNano(0), null, "Admin");
                Area a2 = new Area("Departamento de Recursos Materiales y Servicios Generales", "Lic. Javier Olmedo Pérez", LocalDateTime.now().withNano(0), null, "Admin");
                Area a3 = new Area("Dirección General de Atención y Administración a Emergencias", "Mtra. Nadia Leticia Tadeo Benítez", LocalDateTime.now().withNano(0), null, "Admin");
                Area a4 = new Area("Oficina de la Secretaria de Protección Civil", "Dra. Guadalupe Osorno Maldonado", LocalDateTime.now().withNano(0), null, "Admin");
                Area a5 = new Area("Secretaria Particular", "Lic. Eluzai Rodríguez Cruz", LocalDateTime.now().withNano(0), null, "Admin");
                Area a6 = new Area("Coordinación de assesores", "M.A.R.H. Gloria Zoralla Hernández Londoño", LocalDateTime.now().withNano(0), null, "Admin");
                Area a7 = new Area("Dirección General de Planeación y Regulación", "Mtro. José Ramón Cardona Mendoza", LocalDateTime.now().withNano(0), null, "Admin");
                Area a8 = new Area("Secretaria Técnica", "Dra. Ana Elena Taboada Murrieta", LocalDateTime.now().withNano(0), null, "Admin");
                Area a9 = new Area("Departamento de Verificación y Regulación", "Arq. Martha Denisse García Rodríguez", LocalDateTime.now().withNano(0), null, "Admin");
                Area a10 = new Area("Departamento de Unidades y Programas de Protección Civil", "Lic. Adelina Peña Aranda", LocalDateTime.now().withNano(0), null, "Admin");
                Area a11 = new Area("Departamento de Planeación y Estadística", "Lic. Carmen Patricia Méndez Hernández", LocalDateTime.now().withNano(0), null, "Admin");
                Area a12 = new Area("Departamento de Vinculación Interinstitucional", "Lic. José Miguel Valdés García", LocalDateTime.now().withNano(0), null, "Admin");
                Area a13 = new Area("Dirección General de Atención y Administración a Emergencias", "Mtra. Nadia Leticia Tadeo Benítez", LocalDateTime.now().withNano(0), null, "Admin");
                Area a14 = new Area("Subdirección de Atención de Emergencias", "TUM. Bertín Romero Morales", LocalDateTime.now().withNano(0), null, "Admin");
                Area a15 = new Area("Subdirección de Administración de Emergencias", "Ing. Rocío Pineda Márquez", LocalDateTime.now().withNano(0), null, "Admin");
                Area a16 = new Area("Departamento de Manejo de Fuego", "TGIRD. Alejandro Macías Domínguez", LocalDateTime.now().withNano(0), null, "Admin");
                Area a17 = new Area("Departamento de Atención a Emergencias", "Lic. Moisés Héctor Ochoa Ramírez", LocalDateTime.now().withNano(0), null, "Admin");
                Area a18 = new Area("Oficina del Centro de Comunicaciones", "Lic. Rosa Irma Lagunes Morales", LocalDateTime.now().withNano(0), null, "Admin");
                Area a19 = new Area("Dirección General de Prevención de Riesgo de Desastres", "Lic. Alma Angélica Fuertes Jara", LocalDateTime.now().withNano(0), null, "Admin");
                Area a20 = new Area("Subdirección de Análisis, Evaluación y Reducción de Riesgos", "Mtra. Beatriz Adriana Hernández Yobal", LocalDateTime.now().withNano(0), null, "Admin");
                Area a21 = new Area("Subdirecciónde Estudios y Pronósticos Meteorológicos", "Dr. Saúl Miranda Alonso", LocalDateTime.now().withNano(0), null, "Admin");
                Area a22 = new Area("Departamento de Análisis de Riesgos", "Ing. Carlos Daniel Herrera García", LocalDateTime.now().withNano(0), null, "Admin");
                Area a23 = new Area("Departamento de Atlas de Riesgos", "Lic. Yordan Emanuel Ruiz Meneses", LocalDateTime.now().withNano(0), null, "Admin");
                Area a24 = new Area("Departamento de Intervención Territorial", "Mtra. Grissel Cabrera Rojas", LocalDateTime.now().withNano(0), null, "Admin");
                Area a25 = new Area("Departamento de Pronósticos Meteorológicos y Estacional", "Lic. Federico Acevedo Rosas", LocalDateTime.now().withNano(0), null, "Admin");
                Area a26 = new Area("Departamento de Fenómenos Atmosféricos", "Mtro. José Llanos Arias", LocalDateTime.now().withNano(0), null, "Admin");
                Area a27 = new Area("Dirección de Capacitación, Adiestramiento y Difusión en Materia de Protección Civil", "Mtra. Nancy Alejandra Ortiz Ochoa", LocalDateTime.now().withNano(0), null, "Admin");
                Area a28 = new Area("Departamento de Capacitación y Desarrollo en Protección Civil", "Lic. Ángela María Veintimilla de Jesús", LocalDateTime.now().withNano(0), null, "Admin");
                Area a29 = new Area("Departamento de Programas Pedagógicos en Protección Civil", "Dra. Elsa Yolanda Almeida Monterde", LocalDateTime.now().withNano(0), null, "Admin");
                Area a30 = new Area("Departamento de Difusión y Comunicación", "Lic. Leticia Edith Rosado Olguin", LocalDateTime.now().withNano(0), null, "Admin");
                Area a31 = new Area("Dirección Jurídica", "Mtro. Zenén Hernández Alamilla", LocalDateTime.now().withNano(0), null, "Admin");
                Area a32 = new Area("Unidad Administrativa", "M.C.A. Aurora Alejandra Cervantes Hernández", LocalDateTime.now().withNano(0), null, "Admin");
                Area a33 = new Area("Departamento de Recursos Financieros", "Lic. Carlos Ramón Perea", LocalDateTime.now().withNano(0), null, "Admin");
                Area a34 = new Area("Departamento de Recursos Materiales y Servicios Generales", "L.A.E. Javier Olmedo Pérez", LocalDateTime.now().withNano(0), null, "Admin");
                Area a35 = new Area("Departamento de Recursos Humanos", "L.C. Kena Herrera Parras", LocalDateTime.now().withNano(0), null, "Admin");
                Area a36 = new Area("Departamento de Tecnologías de la Información", "C. Pantoja Rivas Omar Genaro", LocalDateTime.now().withNano(0), null, "Admin");
                Area a37 = new Area("Unidad de Transparencia", "Lic. César Adrián Méndez Olarte", LocalDateTime.now().withNano(0), null, "Admin");
                Area a38 = new Area("Unidad de Género", "Mtra. Estrada Bautista Layda Jacqueline", LocalDateTime.now().withNano(0), null, "Admin");



                areaRepository.saveAll(
                        List.of(a1, a2, a3, a4, a5, a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,
                                a24,a25,a26,a27,a28,a29,a30,a31,a32,a33,a34,a35,a36,a37,a38)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - Area: " + areaRepository.count());
        return null;
    }

    @Bean("Aviso")
    CommandLineRunner commandLineRunner(AvisoRepository avisoRepository) {
        if (avisoRepository.count() == 0) {
            System.out.println(LocalDateTime.now() + " - Inicializando Aviso...");
            avisoRepository.deleteAll();
            return args -> {
                Aviso a1 = new Aviso("Bienvenido/a", "Le damos la bienvenida al Parque Vehicular de la Secretaría de Protección Civil del Estado de Veracruz", LocalDateTime.now().withNano(0), null, "Admin");

                avisoRepository.saveAll(
                        List.of(a1)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - Aviso: " + avisoRepository.count());
        return null;
    }

    @Bean("Resguardante")
    CommandLineRunner commandLineRunner(ResguardanteRepository resguardanteRepository) {
        if (resguardanteRepository.count() == 0) {
            System.out.println(LocalDateTime.now() + " - Inicializando Resguardante...");
            resguardanteRepository.deleteAll();
            return args -> {
                Resguardante r1 = new Resguardante("Mtra. Aurora Alejandra Cervantes Hernández", "Jefa de la Unidad Administrativa", "UC0000001", "C", LocalDate.of(2024, 1, 1), LocalDateTime.now().withNano(0), null, "Admin");
                Resguardante r2 = new Resguardante("Mtra. Nadia Leticia Tadeo Benítez", "Directora General de Atención y Administración a Emergencias", "UC0000002", "C", LocalDate.of(2024, 1, 1), LocalDateTime.now().withNano(0), null, "Admin");

                resguardanteRepository.saveAll(
                        List.of(r1, r2)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - Resguardante: " + resguardanteRepository.count());
        return null;
    }

    @Bean("Vehiculo")
    CommandLineRunner commandLineRunner(VehiculoRepository vehiculoRepository) {
        if (vehiculoRepository.count() == 0) {
            System.out.println(LocalDateTime.now() + " - Inicializando Vehiculo...");
            vehiculoRepository.deleteAll();
            return args -> {

                Vehiculo v1 = new Vehiculo("PC-001", "Hyundai", "H-100", 2012, "Blanco", 4, "YDN7014", "YCW109B", "HECHO EN COREA", "KMFWB3XH0CU381142", "E-3423327", 146320, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "1/214", "Comisiones locales", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v2 = new Vehiculo("PC-002", "Dodge", "Ram-2500", 2012, "Rojo", 8, "XU62096", "XJ3307B", "HECHO EN MÉXICO", "3C6YDAAP7CG121124", "E-3696654", null, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "BAJO RESGUARDO", "2/214", null, categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v3 = new Vehiculo("PC-003", "Dodge", "Ram-2500", 2012, "Rojo", 8, "XU62094", "XJ3312B", "HECHO EN MÉXICO", "3C6YDAAP9CG121125", "E-3696660", 150404, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "BAJO RESGUARDO", "3/214", "Comisiones locales", categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v4 = new Vehiculo("PC-004", "Nissan", "Tsuru", 2000, "Blanco", 4, "YDN7974", "YGY736B", "GA16769436R", "3N1EB31S7YL154997", "E-3421059", null, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "BAJO RESGUARDO", "4/214", null, categoriaRepository.getById(3L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(2L), estatusDocumentalRepository.getById(1L));
                Vehiculo v5 = new Vehiculo("PC-005", "Dodge", "Ram-2500", 2012, "Rojo", 8, "XY01266", "YJ8573A", "HECHO EN MÉXICO", "3C6RDBDT3CG121138", "E-3423328", null, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "BAJO RESGUARDO", "5/214", null, categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v6 = new Vehiculo("PC-006", "Dodge", "Ram-2500", 2012, "Rojo", 8, "XY01265", "XJ3310B", "HECHO EN MÉXICO", "3C6YDAAP6CG121129", "E-3696658", 262882, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "BAJO RESGUARDO", "6/214", "Comisiones locales", categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                //Vehiculo v7 = new Vehiculo("PC-007");
                //Vehiculo v8 = new Vehiculo("PC-008");
                Vehiculo v9 = new Vehiculo("PC-009", "Dodge", "Ram-2500", 2012, "Rojo", 8, "XU62097", "YJ8682A", "HECHO EN MÉXICO", "3C6YDAAP0CG121126", "E-3423343", null, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "BAJO RESGUARDO", "7/214", null, categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                //Vehiculo v10 = new Vehiculo("PC-010");
                Vehiculo v11 = new Vehiculo("PC-011", "Dodge", "Ram-2500", 2004, "Rojo", 8, "N/A", "XY01320", "HECHO EN USA", "1D7HU16N54J173180", "E-0374073", null, LocalDateTime.now().withNano(0), "Admin", "SEFIPLAN", "PROCESO DE BAJA", "8/214", null, categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(2L), estatusCarroceriaRepository.getById(2L), estatusDocumentalRepository.getById(1L));
                //Vehiculo v12 = new Vehiculo("PC-012");
                //Vehiculo v13 = new Vehiculo("PC-013");
                //Vehiculo v14 = new Vehiculo("PC-014");
                Vehiculo v15 = new Vehiculo("PC-015", "Dodge", "Ram-2500", 2012, "Rojo", 8, "N/A", "XV92265", "HECHO EN MÉXICO", "3C6YDAAP4CG121128", "E-1231083", null, LocalDateTime.now().withNano(0), "Admin", "", "BAJO RESGUARDO", "9/214", "Comisiones locales", categoriaRepository.getById(5L), municipioRepository.getById(191L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                //Vehiculo v16 = new Vehiculo("PC-016");
                Vehiculo v17 = new Vehiculo("PC-017", "Dodge", "Ram-2500", 2012, "Rojo", 8, "XY01267", "YJ8683A", "HECHO EN MÉXICO", "3C6YDAAP2CG121130", "E-3423344", 149160, LocalDateTime.now().withNano(0), "Admin", "", "BAJO RESGUARDO", "10/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(16L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v18 = new Vehiculo("PC-018", "Dodge", "Ram-2500", 2012, "Rojo", 8, "XV92887", "YJ8839A", "HECHO EN MÉXICO", "3C6YDAAP2CG121127", "E-3515300", null, LocalDateTime.now().withNano(0), "Admin", "", "COMODATO", "11/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(72L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v19 = new Vehiculo("PC-019", "Dodge", "Ram-2500", 2012, "Rojo", 8, "XY01268", "YJ8684A", "HECHO EN MÉXICO", "3C6RDBDT1CG121137", "E-3423345", null, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "BAJO RESGUARDO", "12/214", null, categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v20 = new Vehiculo("PC-020", "Dodge", "Ram-2500", 2012, "Rojo", 8, "XU65974", "YJ8685A", "HECHO EN MÉXICO", "3C6RDBDT5CG121139", "E-3423346", null, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "BAJO RESGUARDO", "13/214", null, categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                //Vehiculo v21 = new Vehiculo("PC-021");
                //Vehiculo v22 = new Vehiculo("PC-022");
                //Vehiculo v23 = new Vehiculo("PC-023");
                Vehiculo v24 = new Vehiculo("PC-024", "Dodge", "Ram-2500", 2012, "Rojo", 8, "XV45261", "XJ3309B", "HECHO EN MÉXICO", "3C6ZDBAP6CG142251", "E-3696656", null, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "BAJO RESGUARDO", "14/214", "Comisiones locales", categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                //Vehiculo v25 = new Vehiculo("PC-025");
                //Vehiculo v26 = new Vehiculo("PC-026");
                //Vehiculo v27 = new Vehiculo("PC-027");
                //Vehiculo v28 = new Vehiculo("PC-028");
                //Vehiculo v29 = new Vehiculo("PC-029");
                //Vehiculo v30 = new Vehiculo("PC-030");
                Vehiculo v31 = new Vehiculo("PC-031", "Nissan", "Sentra XE", 2006, "Rojo", 4, "YDN8263", "YCW544B", "QG18719588S", "3N1CB51S36L469134", "E-3513547", null, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "BAJO RESGUARDO", "15/214", null, categoriaRepository.getById(3L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v32 = new Vehiculo("PC-032", "Dodge", "Ram-2500", 2012, "Rojo", 8, "XV45260", "YL4735A", "HECHO EN MÉXICO", "3C6ZDBAP1CG129441", "E-3514807", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "16/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(182L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v33 = new Vehiculo("PC-033", "Nissan", "Sentra XE", 2006, "Rojo", 4, "YDN7973", "YKC426B", "QG18721450S", "3N1CB51S06L471388", "E-3513546", 178504, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "BAJO RESGUARDO", "17/214", "Comisiones locales", categoriaRepository.getById(3L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                //Vehiculo v34 = new Vehiculo("PC-034");
                //Vehiculo v35 = new Vehiculo("PC-035");
                //Vehiculo v36 = new Vehiculo("PC-036");
                //Vehiculo v37 = new Vehiculo("PC-037");
                //Vehiculo v38 = new Vehiculo("PC-038");
                //Vehiculo v39 = new Vehiculo("PC-039");
                Vehiculo v40 = new Vehiculo("PC-040", "Susuki", "SX4 Sedan", 2009, "Rojo", 4, "N/A", "YDN8024", "J20A627529", "JS2YC41S595100621", "E-0614983", null, LocalDateTime.now().withNano(0), "Admin", "SEFIPLAN", "PROCESO DE BAJA", "18/214", null, categoriaRepository.getById(3L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(2L), estatusCarroceriaRepository.getById(2L), estatusDocumentalRepository.getById(1L));
                Vehiculo v41 = new Vehiculo("PC-041", "Susuki", "SX4 Sedan", 2009, "Rojo", 4, "N/A", "YDN7984", "J20A611528", "JS2YC41S995100203", "E-0374074", null, LocalDateTime.now().withNano(0), "Admin", "SEFIPLAN", "PROCESO DE BAJA", "19/214", null, categoriaRepository.getById(3L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(2L), estatusCarroceriaRepository.getById(2L), estatusDocumentalRepository.getById(1L));
                Vehiculo v42 = new Vehiculo("PC-042", "Susuki", "SX4 Sedan", 2009, "Rojo", 4, "N/A", "YDN7960", "J20A622951", "JS2YC41SX95100467", "E-0340243", null, LocalDateTime.now().withNano(0), "Admin", "SEFIPLAN", "PROCESO DE BAJA", "20/214", null, categoriaRepository.getById(3L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(2L), estatusCarroceriaRepository.getById(2L), estatusDocumentalRepository.getById(1L));
                //Vehiculo v43 = new Vehiculo("PC-043");
                Vehiculo v44 = new Vehiculo("PC-044", "Susuki", "SX4 Sedan", 2009, "Rojo", 4, "YDN7968", "YHM099B", "J20A624328", "JS2YC41S995100489", "E-0373597", 176607, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "BAJO RESGUARDO", "21/214", "Comisiones locales", categoriaRepository.getById(3L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v45 = new Vehiculo("PC-045", "Susuki", "SX4 Sedan", 2009, "Rojo", 4, "YDN8289", "YCW545B", "J20A633305", "JS2YC41S895100774", "E-3423348", 220257, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "BAJO RESGUARDO", "22/214", "Comisiones locales", categoriaRepository.getById(3L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v46 = new Vehiculo("PC-046", "Susuki", "SX4 Sedan", 2009, "Rojo", 4, "N/A", "YDN8022", "J20A633128", "JS2YC41S795100779", "E-0614985", null, LocalDateTime.now().withNano(0), "Admin", "SEFIPLAN", "PROCESO DE BAJA", "23/214", null, categoriaRepository.getById(3L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(2L), estatusCarroceriaRepository.getById(2L), estatusDocumentalRepository.getById(1L));
                Vehiculo v47 = new Vehiculo("PC-047", "Susuki", "SX4 Sedan", 2009, "Rojo", 4, "YDN7967", "YGY737B", "J20A630050", "JS2YC41S995100718", "E-3421061", 232260, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "BAJO RESGUARDO", "24/214", "Comisiones locales", categoriaRepository.getById(3L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v48 = new Vehiculo("PC-048", "Susuki", "SX4 Sedan", 2009, "Rojo", 4, "N/A", "YDN8290", "J20A634447", "JS2YC41S995100802", "E-0940275", null, LocalDateTime.now().withNano(0), "Admin", "SEFIPLAN", "PROCESO DE BAJA", "25/214", null, categoriaRepository.getById(3L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(2L), estatusCarroceriaRepository.getById(2L), estatusDocumentalRepository.getById(1L));
                //Vehiculo v49 = new Vehiculo("PC-049");
                //Vehiculo v50 = new Vehiculo("PC-050");
                //Vehiculo v51 = new Vehiculo("PC-051");
                //Vehiculo v52 = new Vehiculo("PC-052");
                //Vehiculo v53 = new Vehiculo("PC-053");
                //Vehiculo v54 = new Vehiculo("PC-054");
                //Vehiculo v55 = new Vehiculo("PC-055");
                //Vehiculo v56 = new Vehiculo("PC-056");
                //Vehiculo v57 = new Vehiculo("PC-057");
                //Vehiculo v58 = new Vehiculo("PC-058");
                //Vehiculo v59 = new Vehiculo("PC-059");
                Vehiculo v60 = new Vehiculo("PC-060", "Nissan", "Frontier", 2013, "Rojo", 4, "XY01691", "YJ8686A", "KA24611050A", "3N6DD23T1DK044155", "E-3423349", 195695, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero", "BAJO RESGUARDO", "26/214", "Comisiones locales", categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v61 = new Vehiculo("PC-061", "Nissan", "Frontier", 2013, "Rojo", 4, "XY01692", "YM7809A", "KA214597589A", "3N6DD23TXDK020016", "E-3517836", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "27/214", "Comisiones locales", categoriaRepository.getById(5L), municipioRepository.getById(171L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v62 = new Vehiculo("PC-062", "Nissan", "Frontier", 2013, "Rojo", 4, "XY01693", "YK8844A", "KA24607701A", "3N6DD23T7DK037212", "E-3426831", 168256, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero", "BAJO RESGUARDO", "28/214", "Comisiones locales", categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v63 = new Vehiculo("PC-063", "Nissan", "Frontier", 2013, "Rojo", 4, "XY01694", "YJ8394A", "KA24597344A", "3N6DD23T0DK019859", "E-3423313", 145873, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero", "BAJO RESGUARDO", "29/214", "Comisiones locales", categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v64 = new Vehiculo("PC-064", "Nissan", "Frontier", 2013, "Rojo", 4, "XY01695", "YK8845A", "KA24600710A", "3N6DD23T2DK025209", "E-3426832", null, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "30/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(109L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v65 = new Vehiculo("PC-065", "Nissan", "Frontier", 2013, "Rojo", 4, "XY01696", "YJ8687A", "KA24586515A", "3N6DD23T9DK008004", "E-3423350", 274219, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero", "BAJO RESGUARDO", "31/214", "Comisiones locales", categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v66 = new Vehiculo("PC-066", "Nissan", "Frontier", 2013, "Rojo", 4, "XY01697", "YJ8393A", "KA24593790A", "3N6DD23T8DK014554", "E-3423312", 240950, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "32/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(71L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v67 = new Vehiculo("PC-067", "Nissan", "Frontier", 2013, "Rojo", 4, "XY01698", "YG7364A", "KA24602897A", "3N6DD23T9DK028463", "E-3421062", 161154, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero", "BAJO RESGUARDO", "33/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v68 = new Vehiculo("PC-068", "Nissan", "Frontier", 2013, "Rojo", 4, "N/A", "XY01699", "KA24610468A", "3N6DD23TXDK043103", "E-1404513", 149802, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "34/214", "Comisiones locales", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v69 = new Vehiculo("PC-069", "Ford", "F350", 2013, "Rojo", 8, "XY01703", "YL4734A", "HECHO EN MÉXICO", "1FDEF3G68CEC89650", "E-3514806", 35823, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero", "BAJO RESGUARDO", "35/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v70 = new Vehiculo("PC-070", "Toyota", "Tacoma", 2013, "Blanco", 6, "XY01384", "YJ8626A", "1GR884859", "3TMLU4EN4DM123039", "E-3423331", 213094, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "36/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(131L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                //Vehiculo v71 = new Vehiculo("PC-071");
                Vehiculo v72 = new Vehiculo("PC-072", "Toyota", "Hilux", 2013, "Blanco", 4, "XY01385", "YJ8575A", "2TR7457553", "MR0EX32G5D0005876", "E-3423330", 270259, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "37/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v73 = new Vehiculo("PC-073", "Nissan", "Np300", 2014, "Rojo", 4, "XX07847", "XJ3311B", "KA24736610A", "3N6DD23T5EK091142", "E-3696659", 128405, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero", "BAJO RESGUARDO", "38/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v74 = new Vehiculo("PC-074", "Toyota", "Sequola", 2013, "Plata", 8, "N/A", "YBM010A", "3UR5738128", "5TDKY5G16DS049414", "E-2100591", 274556, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "39/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(6L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v75 = new Vehiculo("PC-075", "Toyota", "Corolla", 2013, "Blanco", 4, "YDN8162", "YHM089B", "2ZRK864855", "2T1BU4EE3DC085940", "E-3423315", 144813, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "40/214", "Comisiones foráneas", categoriaRepository.getById(3L), municipioRepository.getById(87L), areaRepository.getById(6L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v76 = new Vehiculo("PC-076", "Toyota", "Corolla", 2013, "Blanco", 4, "YDN8160", "YGM292B", "2ZRK873242", "2T1BU4EE9DC091113", "E-3418609", 213367, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "41/214", "Comisiones foráneas", categoriaRepository.getById(3L), municipioRepository.getById(87L), areaRepository.getById(6L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v77 = new Vehiculo("PC-077", "Toyota", "Corolla", 2013, "Blanco", 4, "YDN8161", "YGM293B", "2ZRK863103", "2T1BU4EE6DC083521", "E-3418610", 187841, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "42/214", "Comisiones foráneas", categoriaRepository.getById(3L), municipioRepository.getById(87L), areaRepository.getById(6L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                //Vehiculo v78 = new Vehiculo("PC-078");
                Vehiculo v79 = new Vehiculo("PC-079", "Dodge", "Ram-2500", 2013, "Rojo", 8, "XY01400", "YJ8773A", "HECHO EN MÉXICO", "3C6KRBAT5DG585878", "E-3425623", 191437, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero", "BAJO RESGUARDO", "43/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v80 = new Vehiculo("PC-080", "Dodge", "Ram-2500", 2013, "Rojo", 8, "XY01452", "YG7363A", "HECHO EN MÉXICO", "3C6KRBATXDG585875", "E-3421060", 182168, LocalDateTime.now().withNano(0), "Admin", "Taller Álvarez Diez", "BAJO RESGUARDO", "44/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v81 = new Vehiculo("PC-081", "Dodge", "Ram-2500", 2013, "Rojo", 8, "XY01462", "YJ8774A", "HECHO EN MÉXICO", "3C6KRBAT2DG585871", "E-3425624", 115708, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "45/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(71L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v82 = new Vehiculo("PC-082", "Dodge", "Ram-2500", 2013, "Rojo", 8, "XY01463", "YJ8775A", "HECHO EN MÉXICO", "3C6KRBAT4DG585872", "E-3425625", 105771, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "46/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                //Vehiculo v83 = new Vehiculo("PC-083");
                Vehiculo v84 = new Vehiculo("PC-084", "Susuki", "Cuatrimoto", 2014, "Rojo", 4, "N/A", "Z72JT", "R407149174", "5SAAR41A2E7100790", "E-1538872", 3275, LocalDateTime.now().withNano(0), "Admin", "Almacén SPC", "BAJO RESGUARDO", "47/214", "Comisiones locales", categoriaRepository.getById(4L), municipioRepository.getById(87L), areaRepository.getById(3L), resguardanteRepository.getById(2L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v85 = new Vehiculo("PC-085", "Susuki", "Cuatrimoto", 2014, "Rojo", 4, "Z74JT", "01YPJ4", "R407148915", "5SAAR41A2E7100756", "E-3513544", null, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "48/214", "Comisiones locales", categoriaRepository.getById(4L), municipioRepository.getById(118L), areaRepository.getById(3L), resguardanteRepository.getById(2L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v86 = new Vehiculo("PC-086", "Susuki", "Cuatrimoto", 2014, "Rojo", 4, "Z71JT", "93YPJ3", "R407148890", "5SAAR41A9E7100754", "E-3513543", 3393, LocalDateTime.now().withNano(0), "Admin", "Almacén SPC", "BAJO RESGUARDO", "49/214", "Comisiones locales", categoriaRepository.getById(4L), municipioRepository.getById(87L), areaRepository.getById(3L), resguardanteRepository.getById(2L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v87 = new Vehiculo("PC-087", "Susuki", "Cuatrimoto", 2014, "Rojo", 4, "Z73JT", "02YPJ4", "R407148913", "5SAAR41A0E7100755", "E-3513545", 6751, LocalDateTime.now().withNano(0), "Admin", "Almacén SPC", "BAJO RESGUARDO", "50/214", "Comisiones locales", categoriaRepository.getById(4L), municipioRepository.getById(87L), areaRepository.getById(3L), resguardanteRepository.getById(2L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v88 = new Vehiculo("PC-088", "Dodge", "Ram-4000", 2014, "Rojo", 8, "XW87988", "YJ8768A", "HECHO EN MÉXICO", "3C7WRAKT6EG159706", "E-3425627", 123010, LocalDateTime.now().withNano(0), "Admin", "Almacén SPC", "BAJO RESGUARDO", "51/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v89 = new Vehiculo("PC-089", "Chevrolet", "Silverado", 2015, "Vino", 8, "XX27231", "YJ8574A", "HECHO EN MÉXICO", "3GCUK9EC7FG413556", "E-3423329", 109794, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "52/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v90 = new Vehiculo("PC-090", "Chevrolet", "Silverado", 2015, "Blanco", 8, "XX27232", "YJ8395A", "HECHO EN MÉXICO", "1GCNK9EC3FZ285448", "E-3423316", 122327, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "53/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v91 = new Vehiculo("PC-091", "Chevrolet", "Silverado", 2015, "Blanco", 8, "XX27233", "YJ8767A", "HECHO EN MÉXICO", "1GCNK9EC3FZ285384", "E-3425626", 66339, LocalDateTime.now().withNano(0), "Admin", "Taller Álvarez Diez", "BAJO RESGUARDO", "54/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v92 = new Vehiculo("PC-092", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6505A", "HECHO EN MÉXICO", "3GCPY9EH7LG217457", "E-2898403", 57982, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "55/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v93 = new Vehiculo("PC-093", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6506A", "HECHO EN MÉXICO", "3GCPY9EH8LG219461", "E-2898412", 69535, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "56/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v94 = new Vehiculo("PC-094", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6507A", "HECHO EN MÉXICO", "3GCPY9EH2LG217088", "E-2898417", 62928, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "57/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v95 = new Vehiculo("PC-095", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6508A", "HECHO EN MÉXICO", "3GCPY9EH4LG216461", "E-2898408", 59719, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "58/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v96 = new Vehiculo("PC-096", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6521A", "HECHO EN MÉXICO", "3GCPY9EH7LG217636", "E-2898435", 54687, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "59/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v97 = new Vehiculo("PC-097", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6524A", "HECHO EN MÉXICO", "3GCPY9EH0LG218580", "E-2898443", 70179, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "60/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v98 = new Vehiculo("PC-098", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6525A", "HECHO EN MÉXICO", "3GCPY9EH9LG219033", "E-2898441", 69821, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "61/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v99 = new Vehiculo("PC-099", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6526A", "HECHO EN MÉXICO", "3GCPY9EH9LG219016", "E-2898460", 67827, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "62/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v100 = new Vehiculo("PC-100", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6527A", "HECHO EN MÉXICO", "3GCPY9EH3LG218475", "E-2898461", 55134, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "63/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v101 = new Vehiculo("PC-101", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6534A", "HECHO EN MÉXICO", "3GCPY9EH8LG218293", "E-2898476", 70096, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "64/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v102 = new Vehiculo("PC-102", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6662A", "HECHO EN MÉXICO", "3GCPY9EH3LG215527", "E-2940670", 67790, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "65/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(2L), estatusDocumentalRepository.getById(1L));
                Vehiculo v103 = new Vehiculo("PC-103", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6498A", "HECHO EN MÉXICO", "3GCPY9EH3LG218704", "E-2898327", null, LocalDateTime.now().withNano(0), "Admin", "SEDEMA", "BAJO RESGUARDO", "66/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v104 = new Vehiculo("PC-104", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6663A", "HECHO EN MÉXICO", "3GCPY9EH8LG219119", "E-2940665", 29422, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "67/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(3L), estatusDocumentalRepository.getById(1L));
                Vehiculo v105 = new Vehiculo("PC-105", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6664A", "HECHO EN MÉXICO", "3GCPY9EH7LG218897", "E-2940668", 43256, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "68/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v106 = new Vehiculo("PC-106", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6712A", "HECHO EN MÉXICO", "3GCPY9EH3LG218637", "E-2941463", 106491, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "69/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(123L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v107 = new Vehiculo("PC-107", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6531A", "HECHO EN MÉXICO", "3GCPY9EH8LG216849", "E-2898450", 80624, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "70/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(124L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v108 = new Vehiculo("PC-108", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0848A", "HECHO EN MÉXICO", "3GCPY9EH6LG219247", "E-2942353", 52211, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "71/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v109 = new Vehiculo("PC-109", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XV2207A", "HECHO EN MÉXICO", "3GCPY9EH4LG214872", "E-2974781", 41204, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "72/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(72L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v110 = new Vehiculo("PC-110", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6702A", "HECHO EN MÉXICO", "3GCPY9EH3LG214734", "E-2940883", 52981, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "73/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(189L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v111 = new Vehiculo("PC-111", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6772A", "HECHO EN MÉXICO", "3GCPY9EH0LG218594", "E-2941731", 44525, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "74/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(131L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v112 = new Vehiculo("PC-112", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0849A", "HECHO EN MÉXICO", "3GCPY9EH9LG219243", "E-2942352", 63324, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "75/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(102L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v113 = new Vehiculo("PC-113", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0836A", "HECHO EN MÉXICO", "3GCPY9EH0LG219308", "E-2942284", 49919, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "76/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(44L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v114 = new Vehiculo("PC-114", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6703A", "HECHO EN MÉXICO", "3GCPY9EH9LG216553", "E-2940888", 51949, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "77/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(118L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v115 = new Vehiculo("PC-115", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0823A", "HECHO EN MÉXICO", "3GCPY9EH6LG219412", "E-2942224", 32315, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "78/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(201L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v116 = new Vehiculo("PC-116", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6736A", "HECHO EN MÉXICO", "3GCPY9EH2LG216555", "E-2941582", null, LocalDateTime.now().withNano(0), "Admin", null, "PROCESO DE BAJA", "79/214", "Unidad siniestrada", categoriaRepository.getById(5L), null, areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(2L), estatusCarroceriaRepository.getById(2L), estatusDocumentalRepository.getById(1L));
                Vehiculo v117 = new Vehiculo("PC-117", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0834A", "HECHO EN MÉXICO", "3GCPY9EHXLG213435", "E-2942285", 52025, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "60/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(193L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v118 = new Vehiculo("PC-118", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6735A", "HECHO EN MÉXICO", "3GCPY9EH8LG219427", "E-2941583", 64728, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "61/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(16L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v119 = new Vehiculo("PC-119", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6665A", "HECHO EN MÉXICO", "3GCPY9EH1LG216336", "E-2940667", 58916, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "62/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v120 = new Vehiculo("PC-120", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6673A", "HECHO EN MÉXICO", "3GCPY9EHXLG215993", "E-2940705", 59546, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "63/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(38L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v121 = new Vehiculo("PC-121", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6713A", "HECHO EN MÉXICO", "3GCPY9EH8LG207973", "E-2941464", 53652, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "64/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(128L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v122 = new Vehiculo("PC-122", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0850A", "HECHO EN MÉXICO", "3GCPY9EH6LG218941", "E-2942348", 53945, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "65/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(207L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v123 = new Vehiculo("PC-123", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6690A", "HECHO EN MÉXICO", "3GCPY9EH5LG218509", "E-2940805", 46695, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "66/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(45L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v124 = new Vehiculo("PC-124", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0835A", "HECHO EN MÉXICO", "3GCPY9EH5LG214153", "E-2942283", 50769, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "67/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(39L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v125 = new Vehiculo("PC-125", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX4053A", "HECHO EN MÉXICO", "3GCPY9EH6LG218647", "E-2979216", 40306, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "68/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(141L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v126 = new Vehiculo("PC-126", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6683A", "HECHO EN MÉXICO", "3GCPY9EH8LG218598", "E-2940752", 51512, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "69/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(108L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v127 = new Vehiculo("PC-127", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0870A", "HECHO EN MÉXICO", "3GCPY9EH9LG218934", "E-2943096", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "70/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(131L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v128 = new Vehiculo("PC-128", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XL8904A", "HECHO EN MÉXICO", "3GCPY9EH5LG213018", "E-2894510", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "71/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(89L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v129 = new Vehiculo("PC-129", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0880A", "HECHO EN MÉXICO", "3GCPY9EH8LG215040", "E-2943171", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "29/214", "Comisiones foráneas", categoriaRepository.getById(5L),municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v130 = new Vehiculo("PC-130", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0847A", "HECHO EN MÉXICO", "3GCPY9EH3LG212515", "E-2942345", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "30/214", "Comisiones foráneas", categoriaRepository.getById(5L),municipioRepository.getById(183L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v131 = new Vehiculo("PC-131", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XV2192A", "HECHO EN MÉXICO", "3GCPY9EHXLG218859", "E-2974675", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "31/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(95L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v132 = new Vehiculo("PC-132", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XV2149A", "HECHO EN MÉXICO", "3GCPY9EH1LG211802", "E-2974412", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "32/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(124L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v133 = new Vehiculo("PC-133", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "N/A", "HECHO EN MÉXICO", "3GCPY9EH7LG213375", "N/A", null, LocalDateTime.now().withNano(0), "Admin", null, "PROCESO DE BAJA", "33/214", "Comisiones foráneas", categoriaRepository.getById(5L), null, areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(2L), estatusCarroceriaRepository.getById(2L), estatusDocumentalRepository.getById(1L));
                Vehiculo v134 = new Vehiculo("PC-134", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6785A", "HECHO EN MÉXICO", "3GCPY9EH9LG212809", "E-2941784", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "34/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(204L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v135 = new Vehiculo("PC-135", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "YG7004A", "HECHO EN MÉXICO", "3GCPY9EH5LG216663", "E-3419263", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "35/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(198L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v136 = new Vehiculo("PC-136", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0852A", "HECHO EN MÉXICO", "3GCPY9EH4LG211129", "E-2942358", null, LocalDateTime.now().withNano(0), "Admin", null, "PROCESO DE BAJA", "36/214", "Comisiones foráneas", categoriaRepository.getById(5L), null, areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(2L), estatusCarroceriaRepository.getById(2L), estatusDocumentalRepository.getById(1L));
                Vehiculo v137 = new Vehiculo("PC-137", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0841A", "HECHO EN MÉXICO", "3GCPY9EH3LG211641", "E-2942317", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "37/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(39L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v138 = new Vehiculo("PC-138", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0840A", "HECHO EN MÉXICO", "3GCPY9EH4LG207534", "E-2942318", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "38/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(39L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v139 = new Vehiculo("PC-139", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XV2148A", "HECHO EN MÉXICO", "3GCPY9EH6LG208247", "E-2974414", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "39/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(16L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v140 = new Vehiculo("PC-140", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "YA8846A", "HECHO EN MÉXICO", "3GCPY9EHXLG214813", "E-3168747", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "40/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(112L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v141 = new Vehiculo("PC-141", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0828A", "HECHO EN MÉXICO", "3GCPY9EH2LG212506", "E-2942256", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "41/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(108L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v142 = new Vehiculo("PC-142", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "YG7305A", "HECHO EN MÉXICO", "3GCPY9EH3LG214460", "E-3419708", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "42/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(152L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v143 = new Vehiculo("PC-143", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XV2234A", "HECHO EN MÉXICO", "3GCPY9EH1LG213727", "E-3420511", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "43/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v144 = new Vehiculo("PC-144", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0832A", "HECHO EN MÉXICO", "3GCPY9EH4LG211504", "E-2942293", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "44/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(158L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v145 = new Vehiculo("PC-145", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0868A", "HECHO EN MÉXICO", "3GCPY9EH1LG218586", "E-2943099", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "45/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(124L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v146 = new Vehiculo("PC-146", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XV2189A", "HECHO EN MÉXICO", "3GCPY9EH4LG218291", "E-2974667", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "46/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(133L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v147 = new Vehiculo("PC-147", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX4467A", "HECHO EN MÉXICO", "3GCPY9EH7LG211707", "E-3024852", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "47/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(121L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v148 = new Vehiculo("PC-148", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0816A", "HECHO EN MÉXICO", "3GCPY9EH6LG213027", "E-2942179", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "48/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(57L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v149 = new Vehiculo("PC-149", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6704A", "HECHO EN MÉXICO", "3GCPY9EH0LG217512", "E-2940887", null, LocalDateTime.now().withNano(0), "Admin", "OFIGOB", "COMODATO", "49/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v150 = new Vehiculo("PC-150", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0861A", "HECHO EN MÉXICO", "3GCPY9EHXLG217100", "E-2943031", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "50/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(4L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v151 = new Vehiculo("PC-151", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "YM7808A", "HECHO EN MÉXICO", "3GCPY9EH7LG218401", "E-3517470", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "51/214", "Comisiones foráneas", categoriaRepository.getById(5L), null, areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v152 = new Vehiculo("PC-152", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "EN TRÁMITE", "HECHO EN MÉXICO", "3GCPY9EH4LG210563", "EN TRÁMITE", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "52/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(198L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v153 = new Vehiculo("PC-153", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6771A", "HECHO EN MÉXICO", "3GCPY9EH5LG216906", "E-2941733", null, LocalDateTime.now().withNano(0), "Admin", "Escuadrón Nacional de Rescate", "COMODATO", "53/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v154 = new Vehiculo("PC-154", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX0837A", "HECHO EN MÉXICO", "3GCPY9EH4LG218095", "E-2942288", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "54/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(189L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v155 = new Vehiculo("PC-155", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XN6358A", "HECHO EN MÉXICO", "3GCPY9EHXLG218943", "E-2897120", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "55/214", "Comisiones foráneas", categoriaRepository.getById(5L), null, areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v156 = new Vehiculo("PC-156", "Chevrolet", "Silverado", 2020, "Blanco", 6, "N/A", "XX4052A", "HECHO EN MÉXICO", "3GCPY9EH6LG218101", "E-2979215", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "56/214", "Comisiones foráneas", categoriaRepository.getById(5L), municipioRepository.getById(44L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v157 = new Vehiculo("PC-157", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XN6674A", "HECHO EN MÉXICO", "3C7WRAKT7LG113413", "E-2940710", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "57/214", "Comisiones foráneas", categoriaRepository.getById(2L), null, areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v158 = new Vehiculo("PC-158", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XN6675A", "HECHO EN MÉXICO", "3C7WRAKT8LG113419", "E-2940709", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "58/214", "Comisiones foráneas", categoriaRepository.getById(2L), null, areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v159 = new Vehiculo("PC-159", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XN6533A", "74630001", "3HAEUMMR5ML369838", "E-2898479", 10398, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "BAJO RESGUARDO", "59/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(65L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v160 = new Vehiculo("PC-160", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XN6535A", "74630040", "3HAEUMMR4ML369006", "E-2898477", null, LocalDateTime.now().withNano(0), "Admin", null, "PROCESO DE BAJA", "60/214", "Comisiones foráneas", categoriaRepository.getById(6L),null, areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(2L), estatusCarroceriaRepository.getById(2L), estatusDocumentalRepository.getById(1L));
                Vehiculo v161 = new Vehiculo("PC-161", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX0871A", "74629812", "3HAEUMMR5ML368298", "E-2943101", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "61/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(124L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v162 = new Vehiculo("PC-162", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX0869A", "74630046", "3HAEUMMR8ML369011", "E-2943098", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "62/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(131L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v163 = new Vehiculo("PC-163", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX0878A", "74629910", "3HAEUMMR0ML368645", "E-2943173", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "63/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v164 = new Vehiculo("PC-164", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX0879A", "74630631", "3HAEUMMR4ML370267", "E-2943172", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "64/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(108L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v165 = new Vehiculo("PC-165", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX0853A", "74629680", "3HAEUMMR8ML368859", "E-2942361", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "65/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(118L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v166 = new Vehiculo("PC-166", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX0879A", "74631003", "3HAEUMMR9ML370619", "E-3340923", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "66/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(73L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v167 = new Vehiculo("PC-167", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "YE5247A", "74629502", "3HAEUMMR0ML370069", "E-3175470", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "67/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(190L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v168 = new Vehiculo("PC-168", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX4426A", "74629895", "3HAEUMMR7ML368237", "E-3023768", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "68/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(154L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v169 = new Vehiculo("PC-169", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XN6781A", "74631024", "3HAEUMMR8ML371387", "E-2941779", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "69/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(204L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v170 = new Vehiculo("PC-170", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX0862A", "74630819", "3HAEUMMR9ML368515", "E-2943035", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "70/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(160L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v171 = new Vehiculo("PC-171", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "YD3308A", "74630072", "3HAEUMMR4ML369586", "E-3170685", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "71/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(32L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v172 = new Vehiculo("PC-172", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX0851A", "74630387", "3HAEUMMRXML369723", "E-2942357", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "72/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(9L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v173 = new Vehiculo("PC-173", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX0844A", "74630351", "3HAEUMMR8ML367825", "E-2942316", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "73/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(39L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v174 = new Vehiculo("PC-174", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX0811A", "74630464", "3HAEUMMR1ML369593", "E-2942142", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "74/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(141L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v175 = new Vehiculo("PC-175", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "YG7191A", "74630450", "3HAEUMMR1ML367567", "E-3419467", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "75/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(4L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v176 = new Vehiculo("PC-176", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX0881A", "74632020", "3HAEUMMR5ML370004", "E-2943142", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "76/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(133L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v177 = new Vehiculo("PC-177", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX0883A", "74631057", "3HAEUMMR3ML370616", "E-2974658", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "77/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(133L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v178 = new Vehiculo("PC-178", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX4465A", "74632546", "3HAEUMMR1ML370405", "E-3024853", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "78/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(121L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v179 = new Vehiculo("PC-179", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XZ6353A", "74631076", "3HAEUMMR0ML368760", "E-3090320", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "79/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(40L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v180 = new Vehiculo("PC-180", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "YE5235A", "74630701", "3HAEUMMR2ML369831", "E-3175455", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "80/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(119L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v181 = new Vehiculo("PC-181", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX0833A", "74630536", "3HAEUMMR2ML369697", "E-2942295", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "81/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(158L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v182 = new Vehiculo("PC-182", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XN6511A", "74630744", "3HAEUMMR9ML367574", "E-2898378", null, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "COMODATO", "82/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v183 = new Vehiculo("PC-183", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "YM7967A", "74630596", "3HAEUMMR6ML370237", "E-3518322", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "83/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(151L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v184 = new Vehiculo("PC-184", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XY8398A", "74631386", "3HAEUMMR3ML368820", "E-3085148", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "84/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(123L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v185 = new Vehiculo("PC-185", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "EN TRÁMITE", "74629045", "3HAEUMMR5ML369726", "EN TRÁMITE", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "85/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(198L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v186 = new Vehiculo("PC-186", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX4461A", "74630729", "3HAEUMMR8ML368005", "E-3024827", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "86/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(192L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v187 = new Vehiculo("PC-187", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XN6795A", "74633197", "3HAEUMMR5ML371654", "E-2942042", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "87/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(77L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v188 = new Vehiculo("PC-188", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX4460A", "74630169", "3HAEUMMR8ML369767", "E-3024825", null, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "88/214", "Comisiones foráneas", categoriaRepository.getById(6L), null, areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v189 = new Vehiculo("PC-189", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX4448A", "74630778", "3HAEUMMR4ML368289", "E-3023857", 12807, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "89/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(188L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v190 = new Vehiculo("PC-190", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX0857A", "74630438", "3HAEUMMR6ML371663", "E-2942392", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "90/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(128L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v191 = new Vehiculo("PC-191", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XX0890A", "74633152", "3HAEUMMR9ML370684", "E-2943222", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "91/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(118L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v192 = new Vehiculo("PC-192", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "BM830XX", "74630620", "3HAEUMMR8ML371700", "E-3086577", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "92/214", "Comisiones foráneas", categoriaRepository.getById(6L), municipioRepository.getById(68L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v193 = new Vehiculo("PC-193", "International", "Camión Pipa", 2021, "Blanco", 6, "N/A", "XN6588A", "74632526", "3HAEUMMR4ML371645", "E-2899520", 9753, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "93/214", "Comisiones foráneas", categoriaRepository.getById(6L), null, areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v194 = new Vehiculo("PC-194", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XV2129A", "HECHO EN MEXICO", "3C7WRBLJ5LG105457", "E-2943442", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "94/214", "Comisiones foráneas", categoriaRepository.getById(1L), municipioRepository.getById(193L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v195 = new Vehiculo("PC-195", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XX0810A", "HECHO EN MEXICO", "3C7WRBLJXLG113456", "E-2942141", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "95/214", "Comisiones foráneas", categoriaRepository.getById(1L), municipioRepository.getById(141L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v196 = new Vehiculo("PC-196", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XX0867A", "HECHO EN MEXICO", "3C7WRBLJ9LG113450", "E-2943097", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "96/214", "Comisiones foráneas", categoriaRepository.getById(1L), municipioRepository.getById(124L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v197 = new Vehiculo("PC-197", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XN6786A", "HECHO EN MEXICO", "3C7WRBLJ0LG113451", "E-2941785", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "97/214", "Comisiones foráneas", categoriaRepository.getById(1L), municipioRepository.getById(204L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v198 = new Vehiculo("PC-198", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XN6536A", "HECHO EN MEXICO", "3C7WRBLJ2LG113452", "E-2898478", 2797, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "COMODATO", "98/214", "Comisiones foráneas", categoriaRepository.getById(1L), municipioRepository.getById(65L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v199 = new Vehiculo("PC-199", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XX0839A", "HECHO EN MEXICO", "3C7WRBLJ9LG105459", "E-2942315", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "99/214", "Comisiones foráneas", categoriaRepository.getById(1L), municipioRepository.getById(39L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v200 = new Vehiculo("PC-200", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XV2235A", "HECHO EN MEXICO", "3C7WRBLJ7LG105458", "E-3420515", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "00/214", "Comisiones foráneas", categoriaRepository.getById(1L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v201 = new Vehiculo("PC-201", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XX0884A", "HECHO EN MEXICO", "3C7WRBLJ3LG105473", "E-294378", null, LocalDateTime.now().withNano(0), "Admin", null, "PROCESO DE BAJA", "01/214", "Unidad siniestrada", categoriaRepository.getById(1L),null, areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(2L), estatusCarroceriaRepository.getById(2L), estatusDocumentalRepository.getById(1L));
                Vehiculo v202 = new Vehiculo("PC-202", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XX0856A", "HECHO EN MEXICO", "3C7WRBLJ0LG105463", "E-2942393", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "02/214", "Comisiones foráneas", categoriaRepository.getById(1L), municipioRepository.getById(128L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v203 = new Vehiculo("PC-203", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XU7349A", "HECHO EN MEXICO", "3C7WRBLJ6LG105466", "E-2911220", null, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero'", "COMODATO", "03/214", "Comisiones foráneas", categoriaRepository.getById(1L), municipioRepository.getById(65L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v204 = new Vehiculo("PC-204", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XX0826A", "HECHO EN MEXICO", "3C7WRBLJXLG105471", "E-2942240", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "04/214", "Comisiones foráneas", categoriaRepository.getById(1L), null, areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v205 = new Vehiculo("PC-205", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XV2185A", "HECHO EN MEXICO", "3C7WRBLJ2LG113449", "E-2974665", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "05/214", "Comisiones foráneas", categoriaRepository.getById(1L), municipioRepository.getById(28L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v206 = new Vehiculo("PC-206", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XX0889A", "HECHO EN MEXICO", "3C7WRBLJ7LG105461", "E-2943216", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "06/214", "Comisiones foráneas", categoriaRepository.getById(1L), municipioRepository.getById(201L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v207 = new Vehiculo("PC-207", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XX0829A", "HECHO EN MEXICO", "3C7WRBLJ8LG105467", "E-2942254", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "07/214", "Comisiones foráneas", categoriaRepository.getById(1L), municipioRepository.getById(11L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v208 = new Vehiculo("PC-208", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XN6589A", "HECHO EN MEXICO", "3C7WRBLJ5LG105474", "E-2899480", null, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "08/214", "Comisiones foráneas", categoriaRepository.getById(1L), municipioRepository.getById(87L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo v209 = new Vehiculo("PC-209", "Dodge", "Ram-4000", 2020, "Blanco", 8, "N/A", "XN6589A", "HECHO EN MEXICO", "3C7WRBLJ1LG139329", "E-2899479", 3733, LocalDateTime.now().withNano(0), "Admin", "Torre Corporativa 'El Olmo'", "BAJO RESGUARDO", "09/214", "Comisiones locales", categoriaRepository.getById(1L), municipioRepository.getById(87L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo sn210 = new Vehiculo(null, "Ford", "F350", 2013, "Rojo", 8, "N/A", "YJ8390A", "HECHO EN MEXICO", "1FDEF3G65CEB88582", "E-3420709", null, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero", "BAJO RESGUARDO", "N/214", "Comisiones locales", categoriaRepository.getById(1L), municipioRepository.getById(65L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo sn211 = new Vehiculo(null, "Ford", "F350", 2013, "Rojo", 8, "N/A", "S/P", "HECHO EN MEXICO", "1FDEF3G60CEC89691", "N/A", null, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero", "COMODATO", "N/214", "Comisiones locales", categoriaRepository.getById(1L), municipioRepository.getById(65L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo sn212 = new Vehiculo(null, "Ford", "F350", 2013, "Rojo", 8, "N/A", "YJ8389A", "HECHO EN MEXICO", "1FDEF3G69CEC79256", "E-3420706", null, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero", "BAJO RESGUARDO", "N/214", "Comisiones locales", categoriaRepository.getById(1L), municipioRepository.getById(65L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo sn213 = new Vehiculo(null, "Ford", "F350", 2013, "Rojo", 8, "N/A", "S/P", "HECHO EN MEXICO", "1FDEF3G67CE79286", "N/A", null, LocalDateTime.now().withNano(0), "Admin", "Aeropuerto el 'Lencero", "COMODATO", "N/214", "Comisiones locales", categoriaRepository.getById(1L), municipioRepository.getById(65L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo sn214 = new Vehiculo(null, "Ford", "F350", 2013, "Rojo", 8, "N/A", "S/P", "HECHO EN MEXICO", "1FDEF3G60CEB90546", "N/A", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "N/214", "Comisiones locales", categoriaRepository.getById(1L), null, areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(2L), estatusDocumentalRepository.getById(1L));
                Vehiculo sn215 = new Vehiculo(null, "Ford", "F350", 2013, "Rojo", 8, "N/A", "S/P", "HECHO EN MEXICO", "1FDEF3G68CEC89583", "N/A", null, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "N/214", "Comisiones locales", categoriaRepository.getById(1L), municipioRepository.getById(44L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo sn216 = new Vehiculo(null, "Ford", "F350", 2013, "Rojo", 8, "N/A", "YJ8387A", "HECHO EN MEXICO", "1FDEF3G61CEC89697", "E-3420710", null, LocalDateTime.now().withNano(0), "Admin", null, "BAJO RESGUARDO", "208/214", "Comisiones locales", categoriaRepository.getById(1L), municipioRepository.getById(123L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo sn217 = new Vehiculo(null, "Ford", "F350", 2013, "Rojo", 8, "N/A", "S/P", "HECHO EN MEXICO", "1FDEF3G63CEC74375", "N/A", null, LocalDateTime.now().withNano(0), "Admin", null, "COMODATO", "N/214", "Comisiones locales", categoriaRepository.getById(1L), municipioRepository.getById(109L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));
                Vehiculo sn218 = new Vehiculo(null, "Ford", "F350", 2013, "Rojo", 8, "N/A", "S/P", "HECHO EN MEXICO", "1FDEF3G62CED22819", "N/A", null, LocalDateTime.now().withNano(0), "Admin", null, "PROCESO DE BAJA", "N/214", "Comisiones locales", categoriaRepository.getById(1L), municipioRepository.getById(87L), areaRepository.getById(3L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(2L), estatusCarroceriaRepository.getById(1L), estatusDocumentalRepository.getById(1L));





                Vehiculo e1 = new Vehiculo("PC_001", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021112", "180", null, null, LocalDateTime.now().withNano(0), "Admin", "Secretaría de Seguridad Pública", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e2 = new Vehiculo("PC_002", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021144", "188", null, null, LocalDateTime.now().withNano(0), "Admin", "H. Ayuntamiento de Minatitlán", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(108L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e3 = new Vehiculo("PC_003", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021262", "192", null, null, LocalDateTime.now().withNano(0), "Admin", "H. Ayuntamiento de Tlacotalpan", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(178L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e4 = new Vehiculo("PC_004", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021142", "200", null, null, LocalDateTime.now().withNano(0), "Admin", "H. Ayuntamiento de Ursulo Galván", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(191L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e5 = new Vehiculo("PC_005", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021152", "183", null, null, LocalDateTime.now().withNano(0), "Admin", "H. Ayuntamiento de Agua Dulce", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(204L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e6 = new Vehiculo("PC_006", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021159", "196", null, null, LocalDateTime.now().withNano(0), "Admin", "H. Ayuntamiento de Agua Catemáco", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(32L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e7 = new Vehiculo("PC_007", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021151", "198", null, null, LocalDateTime.now().withNano(0), "Admin", "H. Ayuntamiento de Coatzacoalcos", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(39L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e8 = new Vehiculo("PC_008", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021168", "182", null, null, LocalDateTime.now().withNano(0), "Admin", "H. Ayuntamiento de Coatzacoalcos", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(39L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e9 = new Vehiculo("PC_009", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021391", "195", null, null, LocalDateTime.now().withNano(0), "Admin", "H. Ayuntamiento de La Antigua", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(16L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e10 = new Vehiculo("PC_010", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021145", "179", null, null, LocalDateTime.now().withNano(0), "Admin", "H. Ayuntamiento de Otatitlán", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(119L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e11 = new Vehiculo("PC_011", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021160", "197", null, null, LocalDateTime.now().withNano(0), "Admin", "H. Ayuntamiento de Chacaltianguis ", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(54L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e12 = new Vehiculo("PC_012", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021169", "186", null, null, LocalDateTime.now().withNano(0), "Admin", "H. Ayuntamiento de Pajapan", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(122L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e13 = new Vehiculo("PC_013", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021146", "199", null, null, LocalDateTime.now().withNano(0), "Admin", "Secretaría de Seguridad Pública", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e14 = new Vehiculo("PC_014", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021390", "194", null, null, LocalDateTime.now().withNano(0), "Admin", "Secretaría de Seguridad Pública", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e15 = new Vehiculo("PC_015", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021154", "191", null, null, LocalDateTime.now().withNano(0), "Admin", "H. Ayuntamiento de Tecolutla", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(158L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e16 = new Vehiculo("PC_016", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021263", "193", null, null, LocalDateTime.now().withNano(0), "Admin", "Dirección General de Administración y Atención de Emergencias", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e17 = new Vehiculo("PC_017", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021150", "189", null, null, LocalDateTime.now().withNano(0), "Admin", "Dirección General de Administración y Atención de Emergencias", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e18 = new Vehiculo("PC_018", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021153", "190", null, null, LocalDateTime.now().withNano(0), "Admin", "H. Ayuntamiento de Tamiahua ", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(151L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e19 = new Vehiculo("PC_019", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021165", "184", null, null, LocalDateTime.now().withNano(0), "Admin", "En espera de asignación", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), null, areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e20 = new Vehiculo("PC_020", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021170", "187", null, null, LocalDateTime.now().withNano(0), "Admin", "En espera de asignación", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), null, areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e21 = new Vehiculo("PC_021", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021393", "173", null, null, LocalDateTime.now().withNano(0), "Admin", "En espera de asignación", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), null, areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e22 = new Vehiculo("PC_022", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021515", "174", null, null, LocalDateTime.now().withNano(0), "Admin", "Secretaría de Medio Ambiente", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e23 = new Vehiculo("PC_023", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021392", "175", null, null, LocalDateTime.now().withNano(0), "Admin", "Secretaría de Medio Ambiente", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e24 = new Vehiculo("PC_024", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021141", "176", null, null, LocalDateTime.now().withNano(0), "Admin", "Secretaría de Seguridad Pública", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e25 = new Vehiculo("PC_025", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021166", "185", null, null, LocalDateTime.now().withNano(0), "Admin", "Dirección General de Administración y Atención de Emergencias", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e26 = new Vehiculo("PC_026", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021147", "177", null, null, LocalDateTime.now().withNano(0), "Admin", "Dirección General de Administración y Atención de Emergencias", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e27 = new Vehiculo("PC_027", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021143", "178", null, null, LocalDateTime.now().withNano(0), "Admin", "API Veracruz", "COMODATO", null, null, categoriaRepository.getById(7L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e28 = new Vehiculo("PC_028", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021513", "172", null, null, LocalDateTime.now().withNano(0), "Admin", "Dirección General de Administración y Atención de Emergencias", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e29 = new Vehiculo("PC_029", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1021167", "181", null, null, LocalDateTime.now().withNano(0), "Admin", "Dirección General de Administración y Atención de Emergencias", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e30 = new Vehiculo("PC_030", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1058560", "917", null, null, LocalDateTime.now().withNano(0), "Admin", "Dirección General de Administración y Atención de Emergencias", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e31 = new Vehiculo("PC_031", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1056982", "918", null, null, LocalDateTime.now().withNano(0), "Admin", "H. Ayuntamiento de las Choapas", "COMODATO", null, null, categoriaRepository.getById(7L), municipioRepository.getById(61L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e32 = new Vehiculo("PC_032", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1057423", "920", null, null, LocalDateTime.now().withNano(0), "Admin", "Dirección General de Administración y Atención de Emergencias", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(87L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);
                Vehiculo e33 = new Vehiculo("PC_033", "Imemsa", "W-22", 2020, "Blanco", null, null, null, "1069021", "921", null, null, LocalDateTime.now().withNano(0), "Admin", "H. Ayuntamiento de las Alamo ", "COMODATO", null, "Operación y rescate", categoriaRepository.getById(7L), municipioRepository.getById(160L), areaRepository.getById(1L), resguardanteRepository.getById(1L), estatusVehiculoRepository.getById(1L), estatusCarroceriaRepository.getReferenceById(1L), null);




                vehiculoRepository.saveAll(
                        List.of(v1,v2,v3,v4,v5,v6,v9,v11,v15,v17,v18,v19,v20,v24,v31,v32,v33,v40,
                                v41,v42,v44,v45,v46,v47,v48,v60,v61,v62,v63,v64,v65,v66,v67,v68,v69,v70,v72,v73,v74,v75,v76,v77,v79,v80,
                                v81,v82,v84,v85,v86,v87,v88,v89,v90,v91,v92,v93,v94,v95,v96,v97,v98,v99,v100,v101,v102,v103,v104,v105,v106,v107,v108,v109,v110,v111,v112,v113,
                                v114,v115,v116,v117,v118,v119,v120,v121,v122,v123,v124,v125,v126,v127,v128,v129,v130,v131,v132,v133,v134,v135,v136,v137,v138,v139,v140,
                                v141,v142,v143,v144,v145,v146,v147,v148,v149,v150,v151,v152,v153,v154,v155,v156,v157,v158,v159,v160,v161,v162,v163,v164,v165,v166,v167,v168,v169,
                                v170,v171,v172,v173,v174,v175,v176,v177,v178,v179,v180,v181,v182,v183,v184,v185,v186,v187,v188,v189,v190,v191,v192,v193,v194,v195,v196,v197,v198,v199,
                                v200,v201,v202,v203,v204,v205,v206,v207,v208,v209,sn210,sn211,sn212,sn213,sn214,sn215,sn216,sn217,sn218,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,
                                e14,e15,e16,e17,e18,e19,e20,e21,e22,e23,e24,e25,e26,e27,e28,e29,e30,e31,e32,e33)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - Vehiculo: " + vehiculoRepository.count());
        return null;
    }

    @Bean("Contador")
    CommandLineRunner commandLineRunner(ContadorRepository contadorRepository) {
        if (contadorRepository.count() == 0) {
            System.out.println(LocalDateTime.now() + " - Inicializando Contador...");

            String year = String.valueOf(LocalDateTime.now().getYear()).substring(2, 4);
            return args -> {
                Contador c1 = new Contador(1L, "cambioNeumaticos", "N", 0, year);
                Contador c2 = new Contador(2L, "mantenimiento", "M", 0, year);
                Contador c3 = new Contador(3L, "reporteIncidencias", "I", 0, year);
                Contador c4 = new Contador(4L, "resguardoTemporal", "T", 0, year);
                Contador c5 = new Contador(5L, "solicitudCombustibleComision", "C", 0, year);
                Contador c6 = new Contador(6L, "solicitudCombustibleRecarga", "R", 0, year);
                Contador c7 = new Contador(7L, "verificacion", "V", 0, year);

                contadorRepository.saveAll(
                        List.of(c1, c2, c3, c4, c5, c6, c7)
                );
            };
        }
        System.out.println(LocalDateTime.now() + " - Contador: COMPLETOS");
        return null;
    }
}