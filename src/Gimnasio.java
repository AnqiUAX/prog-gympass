public class Gimnasio {

    // 健身房代码
    private String codigo;
    // 健身房名称
    private String nombre;
    // 会员数组
    private Socio[] listaSocios;
    // 房间数组
    private Sala[] listaSalas;
    // 负责人编号(-1是没有的情况）
    private int responsableId;
    // 最大容量
    public final int MAX_SOCIOS;
    public final int MAX_SALAS;

    // 默认容量构造器
    public Gimnasio(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;

        this.MAX_SOCIOS = 12;
        this.MAX_SALAS = 6;

        this.listaSocios = new Socio[MAX_SOCIOS];
        this.listaSalas = new Sala[MAX_SALAS];

        this.responsableId = -1;
    }

    // 判断会员是否存在
    public boolean existeSocio(int numero) {
        boolean resultado = false;

        for (int i = 0; i < MAX_SOCIOS && !resultado; i++) {
            if (listaSocios[i] != null && listaSocios[i].getNumeroSocio() == numero) {
                resultado = true;
            }
        }

        return resultado;
    }

    // 注册会员
    public boolean registrarSocio(Socio s) {
        boolean resultado = false;

        // 先判断对象是否为空，编号是否重复
        if (s != null && !existeSocio(s.getNumeroSocio())) {

            // 找第一个空位
            for (int i = 0; i < MAX_SOCIOS && !resultado; i++) {
                if (listaSocios[i] == null) {
                    listaSocios[i] = s;
                    resultado = true;
                }
            }
        }

        return resultado;
    }

    // 开除会员
    public Socio expulsarSocio(int numero) {
        Socio socioEliminado = null;
        boolean continuarBuscando = true;

        for (int i = 0; i < MAX_SOCIOS && continuarBuscando; i++) {
            if (listaSocios[i] != null && listaSocios[i].getNumeroSocio() == numero) {
                socioEliminado = listaSocios[i];
                listaSocios[i] = null;

                // 如果删掉的是负责人，清空负责人
                if (responsableId == numero) {
                    responsableId = -1;
                }

                continuarBuscando = false;
            }
        }

        return socioEliminado;
    }

    // 指定负责人
    public boolean designarResponsable(int numeroSocio) {
        boolean resultado = false;

        if (existeSocio(numeroSocio)) {
            responsableId = numeroSocio;
            resultado = true;
        }

        return resultado;
    }

    // 添加房间
    public boolean incorporarSala(Sala sala) {
        boolean resultado = false;

        if (sala != null) {

            // 先检查房间编号是否重复
            boolean salaRepetida = false;
            for (int i = 0; i < MAX_SALAS && !salaRepetida; i++) {
                if (listaSalas[i] != null && listaSalas[i].getCodigoSala() == sala.getCodigoSala()) {
                    salaRepetida = true;
                }
            }

            // 不重复时再找空位
            if (!salaRepetida) {
                for (int i = 0; i < MAX_SALAS && !resultado; i++) {
                    if (listaSalas[i] == null) {
                        listaSalas[i] = sala;
                        resultado = true;
                    }
                }
            }
        }

        return resultado;
    }

    // 生成报告
    public String obtenerInforme() {
        StringBuilder sb = new StringBuilder();

        // 标题和基本信息
        sb.append("=== INFORME GYMPASS ===\n");
        sb.append("Codigo: ").append(codigo).append("\n");
        sb.append("Nombre: ").append(nombre).append("\n\n");

        // 统计会员数量
        int sociosOcupados = 0;
        for (int i = 0; i < MAX_SOCIOS; i++) {
            if (listaSocios[i] != null) {
                sociosOcupados++;
            }
        }

        sb.append("Socios: ").append(sociosOcupados).append("/").append(MAX_SOCIOS).append("\n");

        // 显示负责人
        sb.append("Responsable actual: ");
        if (responsableId == -1) {
            sb.append("Sin responsable\n");
        } else {
            Socio responsable = null;

            // 在会员数组里找负责人对象
            for (int i = 0; i < MAX_SOCIOS && responsable == null; i++) {
                if (listaSocios[i] != null && listaSocios[i].getNumeroSocio() == responsableId) {
                    responsable = listaSocios[i];
                }
            }

            if (responsable != null) {
                sb.append(responsable.toString()).append("\n");
            } else {
                sb.append("[").append(responsableId).append("]\n");
            }
        }

        // 会员列表
        sb.append("Listado de socios:\n");
        for (int i = 0; i < MAX_SOCIOS; i++) {
            if (listaSocios[i] != null) {
                sb.append(" - ").append(listaSocios[i].toString()).append("\n");
            }
        }

        sb.append("\n");

        // 统计房间数量
        int salasOcupadas = 0;
        for (int i = 0; i < MAX_SALAS; i++) {
            if (listaSalas[i] != null) {
                salasOcupadas++;
            }
        }

        sb.append("Salas: ").append(salasOcupadas).append("/").append(MAX_SALAS).append("\n");

        // 房间列表
        sb.append("Listado de salas:\n");
        for (int i = 0; i < MAX_SALAS; i++) {
            if (listaSalas[i] != null) {
                sb.append(" - ").append(listaSalas[i].toString()).append("\n");
            }
        }

        return sb.toString();
    }
}