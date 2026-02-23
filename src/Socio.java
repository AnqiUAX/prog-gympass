public class Socio {

    // 封装
    // 会员编号
    private int numeroSocio;
    // 会员姓名
    private String nombre;


    // 构造器用于创建对象时初始化属性
    public Socio(int numeroSocio, String nombre) {
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
    }


    // 获取会员编号
    public int getNumeroSocio() {
        return numeroSocio;
    }

    // 获取会员姓名
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "[" + numeroSocio + "] " + nombre;
    }
}