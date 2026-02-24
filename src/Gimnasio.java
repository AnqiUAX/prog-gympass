
public class Gimnasio {

    // 封装
    // 健身房代码
    private String codigo;
    // 健身房名称
    private String nombre;
    // 会员数组（固定12）
    private Socio[] listaSocios;
    // 房间数组（固定6）
    private Sala[] listaSalas;
    // 当前负责人的会员编号（-1 表示还没有负责人）
    private int responsableId;


    // 构造器作用于创建健身房时初始化基本信息和数组
    public Gimnasio(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaSocios = new Socio[12];
        this.listaSalas = new Sala[6];
        this.responsableId = -1;
    }

    // =========================
    //         会员管理
    // =========================

    // 注册会员：放到第一个空位，不允许重复编号
    public boolean registrarSocio(Socio s) {
        // 防止传入 null
        if (s == null) {
            return false;
        }

        // 先检查是否已经存在相同编号
        if (existeSocio(s.getNumeroSocio())) {
            return false;
        }

        // 找第一个空位置插入
        for (int i = 0; i < listaSocios.length; i++) {
            if (listaSocios[i] == null) {
                listaSocios[i] = s;
                return true;
            }
        }

        // 数组满了，没有位置
        return false;
    }

    // 开除会员：如果存在就删除并返回该对象；不存在返回 null
    public Socio expulsarSocio(int numero) {
        for (int i = 0; i < listaSocios.length; i++) {
            if (listaSocios[i] != null && listaSocios[i].getNumeroSocio() == numero) {
                // 先保存要删除的对象，后面要返回
                Socio eliminado = listaSocios[i];

                // 删除（置空）
                listaSocios[i] = null;

                // 如果被删除的人正好是负责人，负责人清空
                if (responsableId == numero) {
                    responsableId = -1;
                }

                return eliminado;
            }
        }

        return null;
    }

    // 判断会员是否存在
    public boolean existeSocio(int numero) {
        for (int i = 0; i < listaSocios.length; i++) {
            if (listaSocios[i] != null && listaSocios[i].getNumeroSocio() == numero) {
                return true;
            }
        }
        return false;
    }

    // 指定负责人：必须是已经注册的会员
    public boolean designarResponsable(int numeroSocio) {
        if (existeSocio(numeroSocio)) {
            responsableId = numeroSocio;
            return true;
        }
        return false;
    }

    // =========================
    //         房间管理
    // =========================

    // 新增房间：放到第一个空位，不允许重复房间编号
    public boolean incorporarSala(Sala sala) {
        // 防止传入 null
        if (sala == null) {
            return false;
        }

        // 检查房间编号是否重复
        for (int i = 0; i < listaSalas.length; i++) {
            if (listaSalas[i] != null && listaSalas[i].getCodigoSala() == sala.getCodigoSala()) {
                return false;
            }
        }

        // 找第一个空位置插入
        for (int i = 0; i < listaSalas.length; i++) {
            if (listaSalas[i] == null) {
                listaSalas[i] = sala;
                return true;
            }
        }

        // 数组满了
        return false;
    }

    // =========================
    //         报告信息
    // =========================

    // 返回完整报告字符串（这里不打印，只返回字符串）
    public String obtenerInforme() {
        StringBuilder sb = new StringBuilder();

        // 基本信息
        sb.append("=== INFORME GYMPASS ===\n");
        sb.append("Código: ").append(codigo).append("\n");
        sb.append("Nombre: ").append(nombre).append("\n\n");

        // 会员统计
        int sociosOcupados = contarSocios();
        sb.append("Socios: ").append(sociosOcupados).append("/").append(listaSocios.length).append("\n");

        // 负责人信息
        sb.append("Responsable actual: ");
        if (responsableId == -1) {
            sb.append("Sin responsable\n");
        } else {
            Socio responsable = buscarSocioPorNumero(responsableId);
            // 正常情况下应该能找到；这里做个保护
            if (responsable != null) {
                sb.append(responsable.toString()).append("\n");
            } else {
                sb.append("[").append(responsableId).append("]\n");
            }
        }

        // 会员列表
        sb.append("Listado de socios:\n");
        for (int i = 0; i < listaSocios.length; i++) {
            if (listaSocios[i] != null) {
                sb.append(" - ").append(listaSocios[i].toString()).append("\n");
            }
        }

        sb.append("\n");

        // 房间统计
        int salasOcupadas = contarSalas();
        sb.append("Salas: ").append(salasOcupadas).append("/").append(listaSalas.length).append("\n");

        // 房间列表
        sb.append("Listado de salas:\n");
        for (int i = 0; i < listaSalas.length; i++) {
            if (listaSalas[i] != null) {
                sb.append(" - ").append(listaSalas[i].toString()).append("\n");
            }
        }

        return sb.toString();
    }

    // =========================
    // 私有辅助方法
    // =========================

    // 统计当前已注册会员数量
    private int contarSocios() {
        int contador = 0;
        for (int i = 0; i < listaSocios.length; i++) {
            if (listaSocios[i] != null) {
                contador++;
            }
        }
        return contador;
    }

    // 统计当前已添加房间数量
    private int contarSalas() {
        int contador = 0;
        for (int i = 0; i < listaSalas.length; i++) {
            if (listaSalas[i] != null) {
                contador++;
            }
        }
        return contador;
    }

    // 按会员编号查找对象（用于显示负责人信息）
    private Socio buscarSocioPorNumero(int numero) {
        for (int i = 0; i < listaSocios.length; i++) {
            if (listaSocios[i] != null && listaSocios[i].getNumeroSocio() == numero) {
                return listaSocios[i];
            }
        }
        return null;
    }
}