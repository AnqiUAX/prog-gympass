public class Sala {

    // 封装
    // 房间号
    private int codigoSala;
    // 房间描述
    private String descripcion;

    // 构造器用于创建对象时初始化属性
    public Sala(int codigoSala, String descripcion) {
        this.codigoSala = codigoSala;
        this.descripcion = descripcion;
    }

    // 获取房间编号
    public int getCodigoSala() {
        return codigoSala;
    }

    // 获取房间描述
    public String getDescripcion() {
        return descripcion;
    }


    @Override
    public String toString() {
        return "[" + codigoSala + "] " + descripcion;
    }
}