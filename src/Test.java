import java.io.File;
import java.io.InputStream;
import java.util.Scanner;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        System.out.println("请输入用户名：");
        Scanner sc=new Scanner(System.in);
        String username=sc.next();
        System.out.println("你输入的用户名："+username);
        System.out.println("请输入密码：");
        String password=sc.next();
        System.out.println("你输入的密码："+password);

        File file=new File("C:\\Users\\lenovo\\IdeaProjects\\ConsoleShop\\src\\users.xlsx");
        File file1=new File("C:\\Users\\lenovo\\IdeaProjects\\ConsoleShop\\src\\product.xlsx");
        ReadExcel readExcel =new ReadExcel();
        User users[]=readExcel.readExcel(file);

        for(int i=0;i<users.length;i++){
            if(username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())){
                ReadProductExcel readProductExcel=new ReadProductExcel();
                Product products[] = readProductExcel.readExcel(file1);
                for(Product product:products){
                    System.out.print("\t"+product.getpId());
                    System.out.print("\t"+product.getpName());
                    System.out.print("\t"+product.getPrice());
                    System.out.println("\t"+product.getpDesc());
                }
                /*
                遍历数组
                */
                System.out.println("请输入商品ID，把该商品加入购物车：");
                String pId=sc.next();
                int count=0;
                Product productes[]=new Product[3];//创建购物车（用数组模拟）
                ReadProductExcel readProductExcel1=new ReadProductExcel();
                Product product=readProductExcel1.getProductById(pId,file1);
                if(product!=null){
                    System.out.println("找到了该商品");
                    /**
                     * 将该商品加入到购物车
                     */
                    productes[count++]=product;
                }
                break;
            }else{
                System.out.println("登录失败");
            }
        }
    }
}
