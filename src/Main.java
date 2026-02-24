
public class Main {

    public static void main(String[] args) {

        // 1. 创建一个健身房
        Gimnasio gym = new Gimnasio("GP01", "GymPass Centro");

        // 2. 注册 3 个会员
        gym.registrarSocio(new Socio(101, "Ana"));
        gym.registrarSocio(new Socio(102, "Carlos"));
        gym.registrarSocio(new Socio(103, "Lucia"));

        // 3. 添加 2 个房间
        gym.incorporarSala(new Sala(1, "Sala de Musculación"));
        gym.incorporarSala(new Sala(2, "Sala de Cardio"));

        // 4. 指定负责人（必须是已注册会员）
        gym.designarResponsable(102);

        // 5. 打印报告
        System.out.println(gym.obtenerInforme());
    }
}