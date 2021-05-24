
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class Main {
    
    public static void islemleriBastir(){
        
        System.out.println("0-İşlemeleri Görüntüle...");
        System.out.println("1-Bir Sonraki Şehre Git...");
        System.out.println("2-Bir Önceki Şehre Git...");
        System.out.println("3-Uygulamadan Çık.");
        
    }
    
    public static void sehirleriTurla(LinkedList<String> sehirler){
        
        
        ListIterator<String> iterator=sehirler.listIterator();
        
        int islem;
        
        islemleriBastir();
        
        Scanner scanner=new Scanner(System.in);
        
        if (!iterator.hasNext()) {//Yani bu bizimi linked listemiz boşsa buraso true olarak karşımıza çıkacaktır
            
            System.out.println("Her hangi bir şehir bulunmuyor...");
        }
        boolean cikis=false;
        boolean ileri=true;//İleri gitmeyi kontrol edecek değişken
        
        while (!cikis) {
            System.out.print("Bir işlem seçiniz : ");
            
            islem=scanner.nextInt();
            
            switch(islem){
                case 0:
                    islemleriBastir();
                    break;
                    
                case 1:
                     /*
                        Ancak önceki turda eğer geri gidilmişse, burda iteratorumuzu bir ileriye atmamız gerekiyor.
                    Yani aynı yeri göstermeyelim diye iteratorumuzu bir ileriye atmamız gerekiyor.
                    yani ben burda ileri==false olma durumunu kontrol edeceğim.
                    
                    */
                    
                    if (!ileri) {//Burda eğer bir geriye gitmiş ise true olacak...
                        
                        if (iterator.hasNext()) {// bir sonrası için iterator varsa...
                            iterator.next(); //bir ileriye kaydır.
                        }
                        ileri=true;//biz bu turda ileriye gittiğimiz için ilerimizi true yapmamız gerekiyor
                    }
                    
                    if (iterator.hasNext()) {//İteratorun gösterdiği herhangi bir obje var mı?
                        
                        System.out.println("Şehre gidiliyor : "+iterator.next());//Yani biz bir sonraki şehre bu şekilde gitmiş olacağız.
                        
                    }
                    
                    else{//ama eğer bir sonraki kısımda herhangi  bişey gösterilemyecekse.Yani iteratormuz null gösterecek
                        
                        System.out.println("Gidilecek Şehir Kalmadı...");
                        ileri=true;//Biz burda gidilecek şehir kalmadığında ileri=true olmuş demektir
                    }
                    break;
                case 2:
                    /*
                    Ben burda bir sornaki iteratore gidilmiş mi diye kontrol 
                    edeceğim yani ileri=true ise bir geriye gitmemiz lazım.
                    */
                    
                    if (ileri) {//Burda eğer bir ileriye gitmiş ise true olacak...
                        if (iterator.hasPrevious()) {//bir öncesi var mı diye kontrol ediliyor true ise...
                            
                            iterator.previous();//bir geriye kaydır. 
                        }
                        ileri=false;//Biz bu turda geriye gittiğimiz için ilerimizi false yapmamız gerekiyor
                    }
                    
                    /*
                    Önceden bir yer var mı diye kontrol edeceğiz. Çünkü bir önceki obje var mı kontrol etmemiz lazım. 
                    Eğer linkedListimiz boşsa veya en başta ise bizim iteratorumuz yoktur demektir
                    */
                    
                    if (iterator.hasPrevious()) {//Öncesi var mı?
                        System.out.println("Şehre gidiliyor : "+iterator.previous());
                        /*biz burda önceden gösterdiğimiz yere gitmek 
                        istiyoruz o yüzden iterator.previous() kullanıyoruz*/
                    }
                    else{//Eğere önceden gösterdiğimiz yer yoksa en baştadır
                        
                        System.out.println("Şehir Turu Başladı...");
                    }
                    break;
                case 3:
                    System.out.println("Uygulamadan Çıkılıyor...");
                    cikis=true;
                    break; 
            }
            
            
        }
    }
    
    public static void main(String[] args) {
        
        LinkedList<String> sehirler=new LinkedList<String>();
        
        sehirler.add("Ankara");
        sehirler.add("Eskişehir");
        sehirler.add("Afyon");
        
        sehirleriTurla(sehirler);
        
        
    }
    
}
