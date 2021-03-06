package projetografos.ClassesAuxiliares;

import java.util.List;
import javafx.scene.shape.Circle;


public class ListaAdj 
{
    private NoLista inicio;
    
    public void montarLista(List<Circle> lista,List<Arestas> lisAre)
    {
        int vi,vf;
        NoLista aux;
        for (int i = 0; i < lista.size(); i++)
        {
           insVert(i); 
        }
        
        for (int i = 0; i < lisAre.size(); i++)
        {
           vi=lisAre.get(i).getVerticeIni();
           vf=lisAre.get(i).getVerticeFim();
             
           aux=perc(vi);
           aux.getLis().insere(vf, lisAre.get(i).getValor());
           aux.setGrau(aux.getGrau()+1);
           
         
           aux=perc(vf);
           aux.getLis().insere(vi, lisAre.get(i).getValor());
           aux.setGrau(aux.getGrau()+1);
        }
        
        
    }
    
    public NoLista perc(int num)
    {
        NoLista aux=inicio;
        
        while(aux!=null && num>0)
        {
            aux=aux.getProx();
            num--;
        }
        return aux;
    }
    
    private void insVert(int i)
    {
        NoLista no=new NoLista();
        no.setVert(i);
        if(this.inicio==null)
            this.inicio=no;
        else
        {
            NoLista aux=inicio;
            while(aux.getProx()!=null)
                aux=aux.getProx();
            aux.setProx(no);
        }
    }
    
    public NoLista maior()
    {
        int maior=-1;
        NoLista aux=this.inicio;
        NoLista ret=this.inicio;
        while(aux!=null)
        {
            if(aux.getGrau()>maior)
            {
                maior=aux.getGrau();
                ret=aux;
            }
                
            aux=aux.getProx();
        }
        return ret;
    }
    
    public void printar()
    {
        NoLista perc=inicio;
        NoLig perc2;
        while(perc!=null)
        {
            System.out.print(perc.getVert()+" ");
            perc2=perc.getLis().getInicio();
            while(perc2!=null)
            {
                System.out.print(perc2.getVertice()+" ");
                perc2=perc2.getProx();
            }
            System.out.println("");
            perc=perc.getProx();
        }
    }
}
