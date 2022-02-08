package com.example.java_fx;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    //choisebox
    @FXML
    private ChoiceBox<String> Autovehiculul;
    @FXML
    private ChoiceBox<String> Angajatul;
    @FXML
    private ChoiceBox<String> Terenul;
    @FXML
    private ChoiceBox<String> Utilajul;
    @FXML
    private TextField txt_data_activitate;


    //pentru primul tab

    @FXML
    public TableView<Autovehicul> table;
    @FXML
    private TableColumn<Autovehicul,Integer> id_auto;
    @FXML
    private TableColumn<Autovehicul, String> DenumireAutovehicul;
    @FXML
    private TableColumn<Autovehicul, Integer> MentenantaAuto;
    @FXML
    private TableColumn<Autovehicul, Integer> Rezervor;
    @FXML
    private TableColumn<Autovehicul, Integer> cp_maxim;
    @FXML
    private TableColumn<Autovehicul, Integer> cp_nominali;
    @FXML
    private TableColumn<Autovehicul, Date> anulFabricatiei;
    @FXML
    private TableColumn<Autovehicul, Date> anulAchizitiei;
    @FXML
    private TableColumn<Autovehicul,Integer> id_sofer;


    //texturi fields
    @FXML
    private TextField txt_anAuto;
    @FXML
    private TextField txt_anAchizitieAuto;
    @FXML
    private TextField txt_denumireA;
    @FXML
    private TextField txt_maxima;
    @FXML
    private TextField txt_mentenantaA;
    @FXML
    private TextField txt_nominala;
    @FXML
    private TextField txt_rezervor;
    @FXML
    private TextField txt_id_angajat;

    //al doilea tab
    @FXML
    private TableView<Utilaj> table2;
    @FXML
    private TableColumn<Utilaj,Integer> id_utilaj;
    @FXML
    private TableColumn<Utilaj, String> DenumireUtilaj;
    @FXML
    private TableColumn<Utilaj, Integer> PutereMinima;
    @FXML
    private TableColumn<Utilaj, Integer> MentenentaUtilaj;
    @FXML
    private TableColumn<Utilaj, String> UsedFor;
    @FXML
    private TableColumn<Utilaj, Double> Viteza;
    @FXML
    private TableColumn<Utilaj, Date> AnulFabricatiei;
    @FXML
    private TableColumn<Utilaj, Date> AnulAchizitiei;


    //text fields
    @FXML
    private TextField txt_denumireU;
    @FXML
    private TextField txt_viteza;
    @FXML
    private TextField txt_mentenantaU;
    @FXML
    private TextField txt_anAchizitieU;
    @FXML
    private TextField txt_lucrari;
    @FXML
    private TextField txt_putereMinima;
    @FXML
    private TextField txt_AnulFabricatiei;


    //al treilea tab
    @FXML
    private TableView<Teren> table3;
    @FXML
    private TableColumn<Teren,Integer> id_teren;
    @FXML
    private TableColumn<Teren, String> Denumire;
    @FXML
    private TableColumn<Teren, Double> SuprafataAgricola;
    @FXML
    private TableColumn<Teren, String> Stagiu;
    @FXML
    private TableColumn<Teren, Double> ProfitPerRecolta;
    @FXML
    private TableColumn<Teren, Double> RecoltaPrecedenta;
    @FXML
    private TableColumn<Teren, String> FertilizareLevel;
    @FXML
    private TableColumn<Teren, String> Cultura;

    //text fields
    @FXML
    private TextField txt_recolta;
    @FXML
    private TextField txt_stadiu;
    @FXML
    private TextField txt_suprafata;
    @FXML
    private TextField txt_profit;
    @FXML
    private TextField txt_cultura;
    @FXML
    private TextField txt_fertilizare;
    @FXML
    private TextField txt_denumire_teren;

    //tab4
    @FXML
    private TableView<Angajat> table4;
    @FXML
    private TableColumn<Angajat,Integer> id_angajat;
    @FXML
    private TableColumn<Angajat, String> Nume;
    @FXML
    private TableColumn<Angajat, Date> DataNasterii;
    @FXML
    private TableColumn<Angajat, String> DataAngajarii;
    @FXML
    private TableColumn<Angajat, String> RolFerma;
    @FXML
    private TableColumn<Angajat, Integer> Salariu;
    @FXML
    private TableColumn<Angajat, Integer> OreLucrate;
    @FXML
    private TableColumn<Angajat, Integer> CNP;
    @FXML
    private TableColumn<Angajat, String> Categorii;
    //text fields
    @FXML
    private TextField txt_nume;
    @FXML
    private TextField txt_time;
    @FXML
    private TextField txt_rol;
    @FXML
    private TextField txt_salary;
    @FXML
    private TextField txt_data_angajarii;
    @FXML
    private TextField txt_data_nasterii;
    @FXML
    private TextField txt_CNP;
    @FXML
    private TextField txt_categorii;
    ///////tab5

    @FXML
    private TableView<Activitati> table5;
    @FXML
    private TableColumn<Activitati, Date> data_activitatii;
    @FXML
    private TableColumn<Activitati, Integer> angajatulx;
    @FXML
    private TableColumn<Activitati, Integer> autovehicululx;
    @FXML
    private TableColumn<Activitati, Integer> terenulx;
    @FXML
    private TableColumn<Activitati, Integer> utliajulx;


    ObservableList<Autovehicul> list1 ;
    ObservableList<Utilaj> list2;
    ObservableList<Teren> list3;
    ObservableList<Angajat> list4 ;
    ObservableList<Activitati> list5;
    int index = -1;
    Connection conn = null;

    PreparedStatement ps = null;

    @FXML
    public void getSelectedAutovehicul(){
        index = table.getSelectionModel().getSelectedIndex();
        if(index<=-1){
            return;
        }
        txt_denumireA.setText(DenumireAutovehicul.getCellData(index));
        txt_mentenantaA.setText(MentenantaAuto.getCellData(index).toString());
        txt_rezervor.setText(Rezervor.getCellData(index).toString());
        txt_nominala.setText(cp_nominali.getCellData(index).toString());
        txt_maxima.setText(cp_maxim.getCellData(index).toString());
        txt_anAuto.setText(String.valueOf(anulFabricatiei.getCellData(index)));
        txt_anAchizitieAuto.setText(String.valueOf(anulAchizitiei.getCellData(index)));
    }
    @FXML
    public void getSelectedUtilaj(){
        index = table2.getSelectionModel().getSelectedIndex();
        if(index<=-1){
            return;
        }
        txt_denumireU.setText(DenumireUtilaj.getCellData(index));
        txt_mentenantaU.setText(MentenentaUtilaj.getCellData(index).toString());
        txt_lucrari.setText(UsedFor.getCellData(index));
        txt_viteza.setText(String.valueOf(Viteza.getCellData(index)));
        txt_anAchizitieU.setText(String.valueOf(AnulAchizitiei.getCellData(index)));
        txt_AnulFabricatiei.setText(String.valueOf(AnulFabricatiei.getCellData(index)));
        txt_putereMinima.setText(String.valueOf(PutereMinima.getCellData(index)));

    }
    @FXML
    public void getSelectedTeren(){
        index = table3.getSelectionModel().getSelectedIndex();
        if(index<=-1){
            return;
        }
        txt_denumire_teren.setText(Denumire.getCellData(index));
        txt_suprafata.setText(SuprafataAgricola.getCellData(index).toString());
        txt_cultura.setText(Cultura.getCellData(index));
        txt_stadiu.setText(Stagiu.getCellData(index));
        txt_fertilizare.setText(FertilizareLevel.getCellData(index));
        txt_profit.setText(ProfitPerRecolta.getCellData(index).toString());
        txt_recolta.setText(RecoltaPrecedenta.getCellData(index).toString());
    }
    @FXML
    public void getSelectedAngajat(){
        index = table4.getSelectionModel().getSelectedIndex();
        if(index<=-1){
            return;
        }
        txt_nume.setText(Nume.getCellData(index));
        txt_data_nasterii.setText(String.valueOf(DataNasterii.getCellData(index)));
        txt_data_angajarii.setText(String.valueOf(DataAngajarii.getCellData(index)));
        txt_rol.setText(RolFerma.getCellData(index));
        txt_CNP.setText(String.valueOf(CNP.getCellData(index)));
        txt_time.setText(OreLucrate.getCellData(index).toString());
        txt_salary.setText(Salariu.getCellData(index).toString());
        txt_categorii.setText(Categorii.getCellData(index));
    }
    ////////////Metode de adds//////////////////
    public void Add_Autovehicul(){///////de scchimbat ceva
        conn = MyConnection.ConnectDb();
        String sql = "insert into Autovehicule (id_vehicul,denumire,mentenanta,rezervor,putere_nominala,putere_maxima,anul_fabricatiei,anul_achizitiei,id_sofer)VALUES(?,?,?,?,?,?,To_Date(?,'DD.MM.YYYY'),To_Date(?,'DD.MM.YYYY'),?)";
        try {
            assert conn != null;
            Random  rand = new Random();
            ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(rand.nextInt(100)));
            ps.setString(2,txt_denumireA.getText());
            ps.setInt(3,Integer.parseInt(txt_mentenantaA.getText()));
            ps.setInt(4,Integer.parseInt(txt_rezervor.getText()));
            ps.setInt(5,Integer.parseInt(txt_nominala.getText()));
            ps.setInt(6,Integer.parseInt(txt_maxima.getText()));
            ps.setString(7,txt_anAuto.getText());
            ps.setString(8,txt_anAchizitieAuto.getText());
            ps.setInt(9, Integer.parseInt(txt_id_angajat.getText()));

            ps.executeUpdate();
            UpdateTableAutovehicule();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void Add_Utilaj(){
        conn = MyConnection.ConnectDb();//ceva index?
        String sql = "insert into Utilaj (id_utilaj, denumire, putere_minim, mentenanta, lucrari, viteza, anul_fabricatiei,anul_achizitiei)VALUES(?,?,?,?,?,?,to_date(?,'DD.MM.YYYY'),To_date(?,'DD.MM.YYYY'))";
        try{
            assert conn != null;
            ps = conn.prepareStatement(sql);
            Random  rand = new Random();
            ps.setInt(1, Integer.parseInt(String.valueOf(rand.nextInt(100))));
            ps.setString(2,txt_denumireU.getText());
            ps.setInt(3, Integer.parseInt(txt_putereMinima.getText()));
            ps.setInt(4, Integer.parseInt(txt_mentenantaU.getText()));
            ps.setString(5,txt_lucrari.getText());
            ps.setDouble(6, Double.parseDouble(txt_viteza.getText()));
            ps.setString(7,txt_anAchizitieU.getText());
            ps.setString(8,txt_AnulFabricatiei.getText());

            ps.executeUpdate();
            UpdateTabeleUtilaj();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

   public void Add_Teren(){
       conn = MyConnection.ConnectDb();//merge
       String sql= "insert into Teren(id_teren,denumire,suprafata,cultura,stadiu,fertilizare,recolta,profit)VALUES(?,?,?,?,?,?,?,?)";
       try{
           assert conn != null;
           ps = conn.prepareStatement(sql);
           Random  rand = new Random();
           ps.setString(1,String.valueOf(rand.nextInt(100)));
           ps.setString(2,txt_denumire_teren.getText());
           ps.setString(3,txt_suprafata.getText());
           ps.setString(4,txt_cultura.getText());
           ps.setString(5,txt_stadiu.getText());
           ps.setString(6,txt_fertilizare.getText());
           ps.setString(7,txt_recolta.getText());
           ps.setString(8,txt_profit.getText());

           ps.executeUpdate();
           UpdateTableTeren();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
   }

    public void Add_Angajat(){
        conn = MyConnection.ConnectDb();//colum index
        String sql = "insert into Angajati(id_angajat,nume,data_nasterii,data_angajarii,cnp,rol,worktime,salariu,categorii) VALUES(?,?,To_date(?,'DD.MM.YYYY'),To_date(?,'DD.MM.YYYY'),?,?,?,?,?)";
        try {
            assert conn != null;
            ps = conn.prepareStatement(sql);
            Random  rand = new Random();
            ps.setString(1,String.valueOf(rand.nextInt(100)));
            ps.setString(2,txt_nume.getText());
            ps.setString(3,txt_data_nasterii.getText());
            ps.setString(4,txt_data_angajarii.getText());
            ps.setString(5,txt_CNP.getText());
            ps.setString(6,txt_rol.getText());
            ps.setInt(7, Integer.parseInt(txt_time.getText()));
            ps.setString(8,txt_salary.getText());
            ps.setString(9,txt_categorii.getText());

            ps.executeUpdate();
            UpdateTableAngajati();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void AddActivitate(){
        conn = MyConnection.ConnectDb();
        String myteren = Terenul.getValue();
        String myangajat = Angajatul.getValue();
        String myutilaj = Utilajul.getValue();
        String myauto = Autovehiculul.getValue();
        Integer alegereauto = 0;
        Integer alegereteren = 0;
        Integer alegereangajat = 0;
        Integer alegereutilaj = 0;
        ObservableList<ceva> lista = MyConnection.getAutovehiculul();
        ObservableList<ceva> lista2 = MyConnection.getAngajatul();
        ObservableList<ceva> lista3 = MyConnection.getTerenul();
        ObservableList<ceva> lista4 = MyConnection.getUtilajul();

        for (ceva ceva : lista) {
            if (Objects.equals(myauto, ceva.getDenumire()))
                alegereauto = ceva.getId();
        }
        for(ceva ceva :lista2)
            if(Objects.equals(myangajat, ceva.getDenumire()))
                alegereangajat = ceva.getId();
        for(ceva ceva :lista3)
            if(Objects.equals(myteren, ceva.getDenumire()))
                alegereteren = ceva.getId();
        for(ceva ceva :lista4)
            if(Objects.equals(myutilaj, ceva.getDenumire()))
                alegereutilaj = ceva.getId();
       // System.out.println(myteren +" "+myauto+" "+myutilaj+" "+myangajat+" "+" "+alegereteren+" "+alegereauto+" "+alegereutilaj+" "+alegereangajat);
        String sql =  " insert into Activitati(data_activitatii,terenul,autovehiculul,utilajul,angajat)Values(To_date(?,'DD.MM.YYYY'),"+alegereteren.toString()+","+alegereauto.toString()+","+alegereutilaj.toString()+","+alegereangajat.toString()+")";
        try{
            assert conn != null;
            ps = conn.prepareStatement(sql);
            ps.setString(1,txt_data_activitate.getText());

            ps.executeUpdate();
            UpdateTableActivitati();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   ////////Metode de update////////////////
   public void updateAutovehicul(){//eroare de ceva string
       try {
           conn = MyConnection.ConnectDb();
           String val1 = txt_denumireA.getText();
           String val2 = txt_mentenantaA.getText();
           String val3 = txt_rezervor.getText();
           String val4 = txt_nominala.getText();
           String val5 = txt_maxima.getText();
           String val6 = txt_anAuto.getText();
           String val7 = txt_anAchizitieAuto.getText();
           String val8 = txt_id_angajat.getText();


           String sql = "update  Autovehicule set  denumire ='"+val1+"' ,mentenanta ='"+val2+"',rezervor='"+val3+"',putere_nominala ='"+val4+"',putere_maxima='"+val5+"'" +
                   ",anul_fabricatiei=To_Date('"+val6+"','DD.MM.YYYY'),anul_achizitiei=To_Date('"+val7+"','DD.MM.YYYY'),id_sofer='"+val8+"' " +
                   "where denumire = '"+val1+"'" ;
           ps = conn.prepareStatement(sql);

           ps.executeUpdate();
           UpdateTableAutovehicule();

       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
   }


    public void updateUtilaj() {

        try {
            conn = MyConnection.ConnectDb();
            String val1 = txt_denumireU.getText();
            String val2 = txt_putereMinima.getText();
            String val3 = txt_mentenantaU.getText();
            String val4 = txt_lucrari.getText();
            String val5= txt_viteza.getText();
            String val6 = txt_anAchizitieU.getText();
            String val7 = txt_AnulFabricatiei.getText();


            String sql = "update Utilaj set denumire = '"+val1+"',putere_minim = '"+val2+"',mentenanta= '"+val3+"',lucrari= '"+val4+"',viteza= '"+val5+"',anul_achizitiei=To_Date('"+val6+"','DD.MM.YYYY'),anul_fabricatiei =To_Date('"+val7+"','DD.MM.YYYY') where denumire='" + val1 + "'";

            assert conn != null;
            ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            UpdateTabeleUtilaj();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


public void updateTeren(){//aici merge
    try{
        conn = MyConnection.ConnectDb();
        String val1 = txt_denumire_teren.getText();
        String val2 = txt_suprafata.getText();
        String val3 = txt_cultura.getText();
        String val4 = txt_stadiu.getText();
        String val5 = txt_fertilizare.getText();
        String val6 = txt_recolta.getText();
        String val7 = txt_profit.getText();

        String sql = "update Teren  set denumire = '"+val1+"',suprafata='"+val2+"',cultura='"+val3+"',stadiu='"+val4+"',fertilizare='"+val5+"',recolta='"+val6+"',profit='"+val7+"' where denumire ='"+val1+"'";

        ps = conn.prepareStatement(sql);

        ps.executeUpdate();
        UpdateTableTeren();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

  public void updateAngajat(){//string de la data?
      try {
      conn = MyConnection.ConnectDb();
      String val1 = txt_nume.getText();
      String val2 = txt_data_nasterii.getText();
      String val3 = txt_data_angajarii.getText();
      String val4 = txt_CNP.getText();
      String val5 = txt_rol.getText();
      String val6 = txt_time.getText();
      String val7 = txt_salary.getText();
      String val8 = txt_categorii.getText();

      String sql = "update Angajati set nume ='"+val1+"',data_nasterii=To_Date('"+val2+"','DD.MM.YYYY'),data_angajarii=To_Date('"+val3+"','DD.MM.YYYY'), cnp ='"+val4+"',rol='"+val5+"',worktime ='"+val6+"',salariu='"+val7+"',categorii = '"+val8+"'  where nume ='"+val1+"'";

          ps = conn.prepareStatement(sql);


          ps.executeUpdate();
          UpdateTableAngajati();
      } catch (Exception e){
          e.printStackTrace();
      }

  }
    ////////////////////Metods to delete/////////////////
    public void deleteAutovehicul(){
        conn = MyConnection.ConnectDb();
        String sql = "delete from Autovehicule where denumire = ?";
        try {
            assert conn != null;
            ps = conn.prepareStatement(sql);
            ps.setString(1,txt_denumireA.getText());

            ps.executeUpdate();
            updateAutovehicul();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

   public  void deleteUtilaj(){
       conn = MyConnection.ConnectDb();
       String sql = "delete from Utilaj where denumire = ?";
       try {
           assert conn != null;
           ps = conn.prepareStatement(sql);
           ps.setString(1,txt_denumireU.getText());

           ps.executeUpdate();
           UpdateTabeleUtilaj();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
   }
   public void deleteTeren(){
       conn = MyConnection.ConnectDb();
       String sql = "delete from Teren where denumire = ?";
       try{
           assert conn != null;
           ps = conn.prepareStatement(sql);
           ps.setString(1,txt_denumire_teren.getText());

           ps.executeUpdate();
           UpdateTableTeren();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
   }
   public void deleteAngajat(){
       conn = MyConnection.ConnectDb();
       String sql = "delete from Angajati where nume = ?";
       try{
           assert conn != null;
           ps = conn.prepareStatement(sql);
           ps.setString(1,txt_nume.getText());

           ps.executeUpdate();
           UpdateTableAngajati();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
   }
   public void deleteActivitate(){
        conn = MyConnection.ConnectDb();
        String sql = "delete from Activitati where data_activitatii =?";
        try{
            assert conn !=null;
            ps = conn.prepareStatement(sql);
            ps.setString(1,txt_data_activitate.getText());
            ps.executeUpdate();
            UpdateTableActivitati();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
   }
    public void UpdateTableAutovehicule(){
        id_auto.setCellValueFactory(new PropertyValueFactory<>("id_autovehicul"));
        DenumireAutovehicul.setCellValueFactory(new PropertyValueFactory<>("denumireautovehicul"));
        MentenantaAuto.setCellValueFactory(new PropertyValueFactory<>("mentenanta"));
        Rezervor.setCellValueFactory(new PropertyValueFactory<>("rezervor"));
        cp_nominali.setCellValueFactory(new PropertyValueFactory<>("putere_nominal"));
        cp_maxim.setCellValueFactory(new PropertyValueFactory<>("putere_maxim"));
        anulFabricatiei.setCellValueFactory(new PropertyValueFactory<>("anulFabricatiei"));
        anulAchizitiei.setCellValueFactory(new PropertyValueFactory<>("anulAchizitiei"));
        id_sofer.setCellValueFactory(new PropertyValueFactory<>("id_sofer"));

        list1 = MyConnection.getAutovehicul();
        table.setItems(list1);

    }

    public void UpdateTabeleUtilaj(){
        id_utilaj.setCellValueFactory(new PropertyValueFactory<>("id"));
        DenumireUtilaj.setCellValueFactory(new PropertyValueFactory<>("denumireutilaj"));
        PutereMinima.setCellValueFactory(new PropertyValueFactory<>("putereminima"));
        MentenentaUtilaj.setCellValueFactory(new PropertyValueFactory<>("mentenantautilaj"));
        UsedFor.setCellValueFactory(new PropertyValueFactory<>("lucrari"));
        Viteza.setCellValueFactory(new PropertyValueFactory<>("viteza"));
        AnulFabricatiei.setCellValueFactory(new PropertyValueFactory<>("AnFabricatie"));
        AnulAchizitiei.setCellValueFactory(new PropertyValueFactory<>("AnAchizitie"));

        list2 = MyConnection.getUtilaj();
        table2.setItems(list2);

    }

    public void UpdateTableTeren(){
        id_teren.setCellValueFactory(new PropertyValueFactory<>("id_teren"));
        Denumire.setCellValueFactory(new PropertyValueFactory<>("denumire"));
        SuprafataAgricola.setCellValueFactory(new PropertyValueFactory<>("suprafata"));
        Cultura.setCellValueFactory(new PropertyValueFactory<>("cultura"));
        Stagiu.setCellValueFactory(new PropertyValueFactory<>("stadiu"));
        FertilizareLevel.setCellValueFactory(new PropertyValueFactory<>("fertilizare"));
        RecoltaPrecedenta.setCellValueFactory(new PropertyValueFactory<>("recolta"));
        ProfitPerRecolta.setCellValueFactory(new PropertyValueFactory<>("profit"));

        list3 = MyConnection.getTeren();
        table3.setItems(list3);

    }

   public void UpdateTableAngajati(){
       id_angajat.setCellValueFactory(new PropertyValueFactory<>("id_angajat"));
       Nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
       DataNasterii.setCellValueFactory(new PropertyValueFactory<>("data_nasterii"));
       DataAngajarii.setCellValueFactory(new PropertyValueFactory<>("data_angajarii"));
       CNP.setCellValueFactory(new PropertyValueFactory<>("CNP"));
       RolFerma.setCellValueFactory(new PropertyValueFactory<>("rol"));
       OreLucrate.setCellValueFactory(new PropertyValueFactory<>("ore"));
       Salariu.setCellValueFactory(new PropertyValueFactory<>("salariu"));
       Categorii.setCellValueFactory(new PropertyValueFactory<>("categorii_permis"));


       list4 = MyConnection.getAngajat();
       table4.setItems(list4);
   }
   public void UpdateTableActivitati(){
        data_activitatii.setCellValueFactory(new PropertyValueFactory<>("data_activitatii"));
        terenulx.setCellValueFactory(new PropertyValueFactory<>("terenul"));
        autovehicululx.setCellValueFactory(new PropertyValueFactory<>("autovehiculul"));
        utliajulx.setCellValueFactory(new PropertyValueFactory<>("utilajul"));
        angajatulx.setCellValueFactory(new PropertyValueFactory<>("angajat"));

        list5 = MyConnection.getActivitate();
        table5.setItems(list5);


   }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<ceva> lista = MyConnection.getAutovehiculul();
        for (ceva ceva : lista) Autovehiculul.getItems().addAll(ceva.getDenumire());
        ObservableList<ceva> lista2 = MyConnection.getAngajatul();
        for (ceva ceva : lista2) Angajatul.getItems().addAll(ceva.getDenumire());
        ObservableList<ceva> lista3 = MyConnection.getTerenul();
        for (ceva ceva : lista3) Terenul.getItems().addAll(ceva.getDenumire());
        ObservableList<ceva> lista4 = MyConnection.getUtilajul();
        for (ceva ceva : lista4) Utilajul.getItems().addAll(ceva.getDenumire());

        UpdateTableAutovehicule();
        UpdateTabeleUtilaj();
        UpdateTableTeren();
        UpdateTableAngajati();
        UpdateTableActivitati();
    }

}
