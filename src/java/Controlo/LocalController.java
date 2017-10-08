/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlo;

import Commons.Evento;
import Commons.Feedback;
import Commons.Local;
import Commons.HibernateUtil;
import Commons.LocalEvento;
import Commons.LocalEventoId;
import Commons.MaterialEvento;
import Commons.MaterialEventoId;
import Commons.Recurso;
import Commons.Servico;
import Commons.ServicoEvento;
import Commons.ServicoEventoId;
import Commons.TipoEvento;
import Commons.TipoUtilizador;
import Commons.Utilizador;
import Commons.UtilizadorPorEvento;
import Commons.UtilizadorPorEventoId;
import com.google.gson.Gson;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Andre
 */
public class LocalController {
      SessionFactory factory;
        
        public LocalController(){
            factory = HibernateUtil.getSessionFactory();
        }
    
    
    /* Método que cria eventos */
    public Boolean criarEvento (String nomeEvento, String nomeCliente, String contactoCliente, String emailCliente, String descricao, Date dataInicio, Date dataFim, Date horaInicio, Date horaFim, int apoioCamara, int idTipoEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Evento evento = new Evento();
            evento.setNomeEvento(nomeEvento);
            evento.setEstado(0);
            evento.setNomeCliente(nomeCliente);
            evento.setContactoCliente(contactoCliente);
            evento.setEmailCliente(emailCliente);
            evento.setDescricao(descricao);
            evento.setDataInicio(dataInicio);
            evento.setHoraInicio(horaInicio);
            evento.setDataFim(dataFim);
            evento.setHoraFim(horaFim);
            evento.setApoioCamara(apoioCamara);
            evento.setIdTipoEvento(idTipoEvento);
            evento.setVisivel(1);
            session.save(evento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return true;
    }
    
     /* Método que lista Eventos */
    public String listarEvento(){
        Session session = factory.openSession();
        Transaction tx = null;
        List eventos = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            eventos = session.createQuery("FROM Evento E WHERE E.visivel=1").list();
            Gson gson = new Gson();  
            json = gson.toJson(eventos);  
            ToStringBuilder.reflectionToString(eventos);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
        public String listarEventoPorId(int idEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        List eventos = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            eventos = session.createQuery("FROM Evento E WHERE E.visivel=1 AND E.idEvento="+idEvento).list();
            Gson gson = new Gson();  
            json = gson.toJson(eventos);  
            ToStringBuilder.reflectionToString(eventos);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
   /* Método que edita eventos */
    public void editarEvento(int idEvento, String nomeEvento, int estado, String nomeCliente, String contactoCliente, String emailCliente, String descricao, Date dataInicio, Date dataFim, Date horaInicio, Date horaFim, int apoioCamara, int idTipoEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Evento evento = (Evento)session.get(Evento.class, idEvento);
            evento.setIdTipoEvento(idTipoEvento);
            evento.setNomeEvento(nomeEvento);
            evento.setEstado(estado);
            evento.setNomeCliente(nomeCliente);
            evento.setContactoCliente(contactoCliente);
            evento.setEmailCliente(emailCliente);
            evento.setDescricao(descricao);
            evento.setDataInicio(dataInicio);
            evento.setHoraInicio(horaInicio);
            evento.setDataFim(dataFim);
            evento.setHoraFim(horaFim);
            evento.setApoioCamara(apoioCamara);  
            session.update(evento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    
   /* Método que apaga eventos */
     public void removerEvento(int idEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Evento evento = (Evento)session.get(Evento.class, idEvento);
            evento.setVisivel(0);
            session.update(evento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
     
    /* Método que reativa eventos */
     public void reativarEvento(int idEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Evento evento = (Evento)session.get(Evento.class, idEvento);
            evento.setVisivel(1);
            session.update(evento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
     
    /* Método que altera o estado dos eventos */
     public void mudarEstadoEvento(int idEvento, int estado){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Evento evento = (Evento)session.get(Evento.class, idEvento);
            evento.setEstado(estado);
            session.update(evento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

     public String getNomeEvento(int idEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
         try{
            tx = session.beginTransaction();
            List evento = session.createQuery("SELECT E.nomeEvento FROM Evento E WHERE E.idEvento="+idEvento).list();
            Gson gson = new Gson();  
            json = gson.toJson(evento); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return json;
        }
    }
    
    /////////////////////////////////
    //// Metodos de Utilizadores ////
    /////////////////////////////////
    
    /* Método que cria utilizadores */
    public Boolean criarUtilizador(String nicename, String username, String password, String email, String nif, String telemovel, int idTipoUtilizador){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Utilizador utilizador = new Utilizador();
            utilizador.setNicename(nicename);
            utilizador.setUsername(username);
            utilizador.setPassword(password);
            utilizador.setEmail(email);
            utilizador.setNif(nif);
            utilizador.setTelemovel(telemovel);
            utilizador.setIdTipoUtilizador(idTipoUtilizador);
            utilizador.setVisivel(1);
            session.save(utilizador);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
     /* Método que lista Utilizadores */
    public String listarUtilizador(){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            List utilizadores = session.createQuery("FROM Utilizador U").list();
            Gson gson = new Gson();
            json = gson.toJson(utilizadores); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();

        }finally {
            session.close();
        }
        return json;
    }

    /* Método que lista Utilizadores por ID */
    public String listarUtilizadorPorId(int idUtilizador){
        Session session = factory.openSession();
        Transaction tx = null;
        List utilizadores = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            utilizadores = session.createQuery("FROM Utilizador U WHERE U.idUtilizador="+idUtilizador).list();
            Gson gson = new Gson();
            json = gson.toJson(utilizadores);
            ToStringBuilder.reflectionToString(utilizadores);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();

        }finally {
            session.close();
        }
        return json;
    }
    

    /* Método que edita utilizadores */
    public Boolean editarUtilizador(int idUtilizador, String nicename, String username, String password, String email, String nif, String telemovel, int idTipoUtilizador){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Utilizador utilizador = (Utilizador)session.get(Utilizador.class, idUtilizador);
            utilizador.setNicename(nicename);
            utilizador.setPassword(password);
            utilizador.setEmail(email);
            utilizador.setNif(nif);
            utilizador.setTelemovel(telemovel);
            utilizador.setIdTipoUtilizador(idUtilizador);
            session.update(utilizador);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }

    /* Método que apaga Utilizadores */
    public Boolean removerUtilizador(int idUtilizador){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Utilizador utilizador = (Utilizador)session.get(Utilizador.class, idUtilizador);
            utilizador.setVisivel(0);
            session.update(utilizador);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
   /* Método que reativa Utilizadores */
    public Boolean reativarUtilizador(int idUtilizador){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Utilizador utilizador = (Utilizador)session.get(Utilizador.class, idUtilizador);
            utilizador.setVisivel(1);
            session.update(utilizador);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }

   /* Método que muda a permissão de um utilizador */
    public Boolean mudarPermissao(int idUtilizador, int idTipoUtilizador){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Utilizador utilizador = (Utilizador)session.get(Utilizador.class, idUtilizador);
            utilizador.setIdTipoUtilizador(idTipoUtilizador);
            session.update(utilizador);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally{
            session.close();
            return true;
        }
    }

    public String getNomeUtilizador(int idUtilizador){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
         try{
            tx = session.beginTransaction();
            List utilizador = session.createQuery("SELECT U.username FROM Utilizador U WHERE U.idUtilizador="+idUtilizador).list();
            Gson gson = new Gson();  
            json = gson.toJson(utilizador); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return json;
        }
    }
    
    /////////////////////////////
    //// Metodos de Recursos ////
    /////////////////////////////
    
    /* Método que cria recursos */
    public Boolean criarRecurso (int quantidadeDisponivel, String designacao, float valorUnitario){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Recurso recurso = new Recurso();
            recurso.setQuantidadeDisponivel(quantidadeDisponivel);
            recurso.setDesignacao(designacao);
            recurso.setValorUnitario(valorUnitario);
            recurso.setVisivel(1);
            session.save(recurso);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return true;
    }
    
    /* Método que edita recurso */
    public Boolean editarRecurso(int idRecurso, int quantidadeDisponivel, String designacao, float valorUnitario){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Recurso recurso = (Recurso)session.get(Recurso.class, idRecurso);
            recurso.setDesignacao(designacao);
            recurso.setValorUnitario(valorUnitario);
            recurso.setQuantidadeDisponivel(quantidadeDisponivel);
            recurso.setVisivel(1);
            session.update(recurso);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que lista recursos */
    public String listarRecurso(){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            List recursos = session.createQuery("FROM Recurso WHERE visivel = 1").list();
            Gson gson = new Gson();  
            json = gson.toJson(recursos); 
            
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
           
        }finally {
            session.close();
           
        }
        return json;
    }
    
    /* Método que lista recursos por ID */
    public String listarRecursoPorId(int idRecurso){
        Session session = factory.openSession();
        Transaction tx = null;
        List recursos = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            recursos = session.createQuery("FROM Recurso R WHERE R.visivel=1 AND R.idRecurso="+idRecurso).list();
            Gson gson = new Gson();  
            json = gson.toJson(recursos);  
            ToStringBuilder.reflectionToString(recursos);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
    /* Método que apaga recurso */
    public Boolean removerRecurso(int idRecurso){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Recurso recurso = (Recurso)session.get(Recurso.class, idRecurso);
            recurso.setVisivel(0);
            session.update(recurso);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que reativa recurso */
    public Boolean reativarRecurso(int idRecurso){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Recurso recurso = (Recurso)session.get(Recurso.class, idRecurso);
            recurso.setVisivel(1);
            session.update(recurso);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }

    public String getNomeRecurso(int idRecurso){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
         try{
            tx = session.beginTransaction();
            List recurso = session.createQuery("SELECT R.designacao FROM Recruso R WHERE R.idRecurso="+idRecurso).list();
            Gson gson = new Gson();  
            json = gson.toJson(recurso); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return json;
        }
    }
    
    
    
   ///////////////
   //// Login ////
   ///////////////
    
public String logIn(String name, String pass){
        Session session = factory.openSession();
        String result = "false";
        Transaction tx = null;
        String jsont = null;
        String jsonf = null;
        String t = "true";
        String f = "false";      
        //try{
        tx = session.getTransaction();
        tx.begin();
        String sql = "from Utilizador u where u.username=:name and u.password=:pass";
        Query query = session.createQuery(sql);
        query.setParameter("name", name);
        query.setParameter("pass", pass);
        List<Utilizador> list = query.list();
        if (list.size() > 0) {
            Gson gson = new Gson();  
            jsont = gson.toJson(t); 
            session.close();
            return jsont;
        }else{
            Gson gson = new Gson();  
            jsonf = gson.toJson(f); 
            session.close();
            return jsonf;
        }
    }
    
    ////////////////////////////////////
    //// Metodos de Tipos de Evento ////
    ////////////////////////////////////
    
    /* Método que cria tipos de evento */
    public Boolean criarTipoEvento (String designacao){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            TipoEvento tipoevento = new TipoEvento();
            tipoevento.setDesignacao(designacao);
            session.save(tipoevento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return true;
    }
    
    /* Método que lista Eventos */
    public String listarTipoEvento( ){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            List lista = session.createQuery("FROM TipoEvento").list();
            Gson gson = new Gson();  
            json = gson.toJson(lista); 
            
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
     public String listarTipoEventoPorId(int idTipoEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        List tipoEventos = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            tipoEventos = session.createQuery("FROM TipoEvento E WHERE E.idTipoEvento="+idTipoEvento).list();
            Gson gson = new Gson();  
            json = gson.toJson(tipoEventos);  
            ToStringBuilder.reflectionToString(tipoEventos);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
     
     public String listarNomeTipoEvento(int idTipoEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        List tipoEventos = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            tipoEventos = session.createQuery("SELECT E.designacao FROM TipoEvento E WHERE E.idTipoEvento="+idTipoEvento).list();
            Gson gson = new Gson();  
            json = gson.toJson(tipoEventos);  
            ToStringBuilder.reflectionToString(tipoEventos);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
     
    
   /* Método que edita eventos */
    public void editarTipoEvento(int idTipoevento, String descricao){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            TipoEvento tipoevento = (TipoEvento)session.get(TipoEvento.class, idTipoevento);
            tipoevento.setDesignacao(descricao);
            session.update(tipoevento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    
    /* Método que apaga eventos */
    public void removerTipoEvento(int idTipoEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            TipoEvento tipoevento = (TipoEvento)session.get(TipoEvento.class, idTipoEvento);
            session.delete(tipoevento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    
     ////////////////////////////////////////
     //// Metodos de Tipos de Utilizador ////
     ////////////////////////////////////////
    
    /* Método que cria tipo de utilizadores */
    public Boolean criarTipoUtilizador(String designacao){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
            tx = session.beginTransaction();
            TipoUtilizador tipoutilizador = new TipoUtilizador();
            tipoutilizador.setDesignacao(designacao);
            session.save(tipoutilizador);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que lista tipo de Utilizadores */
    public String listarTipoUtilizador(){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            List tipoutilizadores = session.createQuery("FROM TipoUtilizador").list();
            for (Iterator iterator = tipoutilizadores.iterator(); iterator.hasNext();){
                TipoUtilizador tipoutilizador = (TipoUtilizador) iterator.next();
                Gson gson = new Gson();  
                json = gson.toJson(tipoutilizadores); 
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
    public String listarTipoUtilizadorPorId(int idTipoUtilizador){
        Session session = factory.openSession();
        Transaction tx = null;
        List tipoUtilizadores = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            tipoUtilizadores = session.createQuery("FROM TipoUtilizador E WHERE E.idTipoUtilizador="+idTipoUtilizador).list();
            Gson gson = new Gson();  
            json = gson.toJson(tipoUtilizadores);  
            ToStringBuilder.reflectionToString(tipoUtilizadores);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
     public String listarNomeTipoUtilizador(int idTipoUtilizador){
        Session session = factory.openSession();
        Transaction tx = null;
        List tipoUtilizadores = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            tipoUtilizadores = session.createQuery("SELECT E.designacao FROM TipoUtilizador E WHERE E.idTipoUtilizador="+idTipoUtilizador).list();
            Gson gson = new Gson();  
            json = gson.toJson(tipoUtilizadores);  
            ToStringBuilder.reflectionToString(tipoUtilizadores);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
    /* Método que edita tipo de utilizadores */
    public Boolean editarTipoUtilizador(int idTipoUtilizador, String designacao){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            TipoUtilizador tipoutilizador = (TipoUtilizador)session.get(TipoUtilizador.class, idTipoUtilizador);
            tipoutilizador.setDesignacao(designacao);
            session.update(tipoutilizador);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que apaga tipo de Utilizadores */
    public Boolean removerTipoUtilizador(int idTipoUtilizador){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            TipoUtilizador tipoutilizador = (TipoUtilizador)session.get(TipoUtilizador.class, idTipoUtilizador);
            session.delete(tipoutilizador);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /////////////////////////////
    //// Metodos de Serviços ////
    /////////////////////////////
    
    /* Método que cria serviços */
    public Boolean criarServico(String nome, String email, String contacto){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
            tx = session.beginTransaction();
            Servico servico = new Servico();
            servico.setNome(nome);
            servico.setEmail(email);
            servico.setContacto(contacto);
            servico.setVisivel(1);
            session.save(servico);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que lista serviços */
    public String listarServico(){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            List servicos = session.createQuery("FROM Servico S WHERE S.visivel=1").list();
            Gson gson = new Gson();  
            json = gson.toJson(servicos); 
            
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
    /* Método que lista serviços por ID */
    public String listarServicoPorId(int idServico){
        Session session = factory.openSession();
        Transaction tx = null;
        List servicos = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            servicos = session.createQuery("FROM Servico S WHERE S.idServico="+idServico).list();
            Gson gson = new Gson();  
            json = gson.toJson(servicos);  
            ToStringBuilder.reflectionToString(servicos);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
    /* Método que edita serviços */
    public Boolean editarServico(int idServico, String nome, String email, String contacto){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Servico servico = (Servico)session.get(Servico.class, idServico);
            servico.setNome(nome);
            servico.setEmail(email);
            servico.setContacto(contacto);
            session.update(servico);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que apaga serviços */
    public Boolean removerServico(int idServico){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Servico servico = (Servico)session.get(Servico.class, idServico);
            servico.setVisivel(0);
            session.update(servico);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }

    public String getNomeServico(int idServico){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
         try{
            tx = session.beginTransaction();
            List servico = session.createQuery("SELECT S.nome FROM Servico S WHERE S.idServico="+idServico).list();
            Gson gson = new Gson();  
            json = gson.toJson(servico); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return json;
        }
    }
    
    //////////////////////////////
    //// Metodos de Locais ///////
    //////////////////////////////
    
    /* Método que cria locais */
    public Boolean criarLocal(String nome, String codigoPostal, String morada){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
            tx = session.beginTransaction();
            Local local = new Local();
            local.setNome(nome);
            local.setCodigoPostal(codigoPostal);
            local.setMorada(morada);
            session.save(local);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que lista locais */
    public String listarLocal(){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            List locais = session.createQuery("FROM Local").list();
            Gson gson = new Gson();  
            json = gson.toJson(locais); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
        public String listarLocalPorId(int idLocal){
        Session session = factory.openSession();
        Transaction tx = null;
        List locais = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            locais = session.createQuery("FROM Local L WHERE L.idLocal="+idLocal).list();
            Gson gson = new Gson();  
            json = gson.toJson(locais);  
            ToStringBuilder.reflectionToString(locais);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
    /* Método que edita locais */
    public Boolean editarLocal(int idLocal, String nome, String codigoPostal, String morada){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Local local = (Local)session.get(Local.class, idLocal);
            local.setNome(nome);
            local.setCodigoPostal(codigoPostal);
            local.setMorada(morada);
            session.update(local);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que apaga locais */
    public Boolean removerLocal(int idLocal){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Local local = (Local)session.get(Local.class, idLocal);
            session.delete(local);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }

     public String getNomeLocal(int idLocal){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
         try{
            tx = session.beginTransaction();
            List local = session.createQuery("SELECT L.nome FROM Local L WHERE L.idLocal="+idLocal).list();
            Gson gson = new Gson();  
            json = gson.toJson(local); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
            return json;
        }
    }
    
    
    /////////////////////////////
    //// Metodos de Feedback ////
    /////////////////////////////
    
    /* Método que cria feedback */
    public Boolean criarFeedback(int nota, String observacao, int idEvento){
      Session session = factory.openSession();
      Transaction tx = null;
        try{
            Evento evento = (Evento)session.get(Evento.class, idEvento);
            tx = session.beginTransaction();
            Feedback feedback = new Feedback();
            feedback.setIdEvento(idEvento);
            feedback.setNota(nota);
            feedback.setObservacao(observacao);
            session.save(feedback);
            evento.setEstado(4);
            List ids = session.createQuery("SELECT M.id.idRecurso FROM MaterialEvento M WHERE M.id.idEvento="+idEvento).list();
            List quantidades = session.createQuery("SELECT M.quantidadeUsadaRecurso FROM MaterialEvento M WHERE M.id.idEvento="+idEvento).list();
            for (int i = 0; i <ids.size(); i++){
                int idRecurso = (int) ids.get(i);
                int qnt = (int) quantidades.get(i);
                Recurso rec = (Recurso)session.get(Recurso.class, idRecurso);
                int quant = rec.getQuantidadeDisponivel();
                rec.setQuantidadeDisponivel(quant+qnt);
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que lista feedback */
    public String listarFeedback(){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            List feedbacks = session.createQuery("FROM Feedback").list();
            Gson gson = new Gson();  
            json = gson.toJson(feedbacks); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
    /* Método que lista feedback por evento */
    public String listarFeedbackEvento(int idEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            List feedbacks = session.createQuery("FROM Feedback F Where F.idEvento="+idEvento).list();
            Gson gson = new Gson();  
            json = gson.toJson(feedbacks); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
    /* Método que edita feedback */
    public Boolean editarFeedback(int idFeedback, int nota, String observacao){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Feedback feedback = (Feedback)session.get(Feedback.class, idFeedback);
            feedback.setNota(nota);
            feedback.setObservacao(observacao);
            session.update(feedback);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que apaga feedbacks */
    public Boolean removerFeedback(int idFeedback){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Feedback feedback = (Feedback)session.get(Feedback.class, idFeedback);
            session.delete(feedback);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    ////////////////////////////////////
    //// Metodos de Local de Evento ////
    ////////////////////////////////////
    
    /* Método que cria locais de evento */
    public Boolean criarLocalEvento(int idEvento, int idLocal){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
            tx = session.beginTransaction();
            LocalEventoId localEvento = new LocalEventoId();
            localEvento.setIdEvento(idEvento);
            localEvento.setIdLocal(idLocal);
            LocalEvento localEventoID = new LocalEvento();
            localEventoID.setId(localEvento);
            session.save(localEventoID);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que lista locais de eventos */
    public String listarLocalEvento(){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            List locaisEvento = session.createQuery("FROM LocalEvento").list();
            Gson gson = new Gson();  
            json = gson.toJson(locaisEvento); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
    /* Método que edita locais de evento */
    public Boolean editarLocalEvento(int idLocalEvento,int idEvento, int idLocal){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            LocalEventoId localEvento = (LocalEventoId)session.get(LocalEventoId.class, idLocalEvento);
            localEvento.setIdEvento(idEvento);
            localEvento.setIdLocal(idLocal);
            session.update(localEvento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que apaga locais de evento */
    public Boolean removerLocalEvento(int idLocalEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            LocalEventoId localEvento = (LocalEventoId)session.get(LocalEventoId.class, idLocalEvento);
            session.delete(localEvento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    //////////////////////////////////////////
    //// Metodos de Utilizador por Evento ////
    //////////////////////////////////////////
    
    /* Método que cria utilizadores por evento */
    public Boolean criarUtilizadorEvento(int idUtilizador, int idEvento){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
            tx = session.beginTransaction();
            UtilizadorPorEventoId utilizadorEvento = new UtilizadorPorEventoId();
            utilizadorEvento.setIdUtilizador(idUtilizador);
            utilizadorEvento.setIdEvento(idEvento);
            UtilizadorPorEvento utilizadorEventoID = new UtilizadorPorEvento();
            utilizadorEventoID.setId(utilizadorEvento);
            session.save(utilizadorEventoID);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que lista utilizadores por evento */
    public String listarUtilizadorEvento(){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            List utilizadoresEvento = session.createQuery("FROM UtilizadorPorEvento").list();
            Gson gson = new Gson();  
            json = gson.toJson(utilizadoresEvento); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            session.close();
        }
        return json;
    }
    
    /* Método que edita utilizadores por evento */
    public Boolean editarUtilizadorEvento(int idUtilizadorEvento, int idUtilizador, int idEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            UtilizadorPorEventoId utilizadorEvento = (UtilizadorPorEventoId)session.get(UtilizadorPorEventoId.class, idUtilizadorEvento);
            utilizadorEvento.setIdUtilizador(idUtilizador);
            utilizadorEvento.setIdEvento(idEvento);
            session.update(utilizadorEvento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que apaga utilizadores por evento */
    public Boolean removerUtilizadorEvento(int idUtilizadorEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            UtilizadorPorEventoId utilizadorEvento = (UtilizadorPorEventoId)session.get(UtilizadorPorEventoId.class, idUtilizadorEvento);
            session.delete(utilizadorEvento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }

    //////////////////////////////////////////
    //// Metodos de Serviço por Evento ///////
    //////////////////////////////////////////
    
    /* Método que cria serviços por evento */
    public Boolean criarServicoEvento(int idEvento, int idServico){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
            tx = session.beginTransaction();
            ServicoEventoId servicoEvento = new ServicoEventoId();
            servicoEvento.setIdEvento(idEvento);
            servicoEvento.setIdServico(idServico);
            ServicoEvento servicoEventoID = new ServicoEvento();
            servicoEventoID.setId(servicoEvento);
            servicoEventoID.setEstado(0);
            session.save(servicoEventoID);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que lista serviços por evento */
    public String listarServicoEvento(){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            List servicosEvento = session.createQuery("FROM ServicoEvento").list();
            Gson gson = new Gson();  
            json = gson.toJson(servicosEvento); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
    /* Método que edita serviços por evento */
    public Boolean editarServicoEvento(int idServicoEvento, int idEvento, int idServico){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            ServicoEventoId servicoEvento = (ServicoEventoId)session.get(ServicoEventoId.class, idServicoEvento);
            servicoEvento.setIdEvento(idEvento);
            servicoEvento.setIdServico(idServico);
            session.update(servicoEvento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que apaga serviços por evento */
    public Boolean removerServicoEvento(int idServicoEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            ServicoEventoId servicoEvento = (ServicoEventoId)session.get(ServicoEventoId.class, idServicoEvento);
            session.delete(servicoEvento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
   
    public String listarServicoEventoPorId(int idEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            List servicosEvento = session.createQuery("FROM ServicoEvento S WHERE S.id.idEvento="+idEvento).list();
            Gson gson = new Gson();  
            json = gson.toJson(servicosEvento); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
    //////////////////////////////////////////
    //// Metodos de Material por Evento //////
    //////////////////////////////////////////
    
    /* Método que cria material por evento */
    public String criarMaterialEvento(int idEvento, int idRecurso, int quantidadeUsadaRecurso){
      Session session = factory.openSession();
      Transaction tx = null;
      int qt = 0;
      int quantidadeDisp = 0;
      String json = "";
      String erro = "";
      String certo = "Recurso alocado com sucesso";
      try{
            tx = session.beginTransaction();
            Recurso recurso = (Recurso)session.get(Recurso.class, idRecurso);
            quantidadeDisp = recurso.getQuantidadeDisponivel();
            qt = quantidadeDisp - quantidadeUsadaRecurso;
            if(qt < 0){
                erro = "Não há quantidade disponivel suficiente";
                Gson gson = new Gson();  
                json = gson.toJson(erro);
            } else {
                recurso.setQuantidadeDisponivel(qt);
                MaterialEventoId materialEvento = new MaterialEventoId();
                materialEvento.setIdEvento(idEvento);
                materialEvento.setIdRecurso(idRecurso);
                MaterialEvento materialEventoID = new MaterialEvento();
                materialEventoID.setId(materialEvento);
                materialEventoID.setQuantidadeUsadaRecurso(quantidadeUsadaRecurso);
                session.save(materialEventoID);
                Gson gson = new Gson();  
                json = gson.toJson(certo);
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
    /* Método que lista material por evento */
    public String listarMaterialEvento(){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            List materiaisEvento = session.createQuery("FROM MaterialEvento").list();
            Gson gson = new Gson();  
            json = gson.toJson(materiaisEvento); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
    /* Método que edita material por evento */
    public Boolean editarMaterialEvento(int idMaterialEvento, int idEvento, int idRecurso, int quantidadeUsadaRecurso){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            MaterialEventoId materialEvento = (MaterialEventoId)session.get(MaterialEventoId.class, idMaterialEvento);
            materialEvento.setIdEvento(idEvento);
            materialEvento.setIdRecurso(idRecurso);
            session.update(materialEvento);
            MaterialEvento materialEventoID = (MaterialEvento)session.get(MaterialEvento.class, idMaterialEvento);
            materialEventoID.setQuantidadeUsadaRecurso(quantidadeUsadaRecurso);
            session.update(materialEventoID);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    /* Método que apaga material por evento */
    public Boolean removerMaterialEvento(int idMaterialEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            MaterialEventoId materialEvento = (MaterialEventoId)session.get(MaterialEventoId.class, idMaterialEvento);
            session.delete(materialEvento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
            return true;
        }
    }
    
    public String totalEventosMes(int ano, int mes){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        int total = 0;
        try{
            tx = session.beginTransaction();
            List totalEventosMes = session.createQuery("FROM Evento E WHERE E.dataInicio >='"+ano+"-"+mes+"-01' AND E.dataInicio <= '"+ano+"-"+mes+"-31'").list();
            total = totalEventosMes.size();
            Gson gson = new Gson();  
            json = gson.toJson(total); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
    
        public int totalEventosMesMetodo(int ano, int mes){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        int total = 0;
        try{
            tx = session.beginTransaction();
            List totalEventosMes = session.createQuery("FROM Evento E WHERE E.dataInicio >='"+ano+"-"+mes+"-01' AND E.dataInicio <= '"+ano+"-"+mes+"-31'").list();
            total = totalEventosMes.size();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return total;
    }

      public String listarMaterialEventoPorId(int idEvento){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            List materiaisEvento = session.createQuery("FROM MaterialEvento M WHERE M.id.idEvento="+idEvento).list();
            Gson gson = new Gson();  
            json = gson.toJson(materiaisEvento); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return json;
    }
      
    public String disponibilidadeRecursos(Integer idRecurso){
            Session session = factory.openSession();
            Transaction tx = null;
            String json = "";
            int total = 0;
            String mensagemNaoDisp = "o recurso não se encontra disponível";
            String mensagemDisp = "";
            try{
                tx = session.beginTransaction();
                /*Query quantidadeDisponivel = session.createQuery("SELECT R.quantidadeDisponivel FROM Recurso R WHERE R.idRecurso="+idRecurso);
                Integer result = (Integer) quantidadeDisponivel.uniqueResult();*/
                Recurso recurso = (Recurso)session.get(Recurso.class, idRecurso);
                int result = recurso.getQuantidadeDisponivel();
                System.out.println(result);
                if(result>0){
                    mensagemDisp = "o recurso encontra-se disponível e tem em stock "+result+" unidades";
                    Gson gson = new Gson();  
                    json = gson.toJson(mensagemDisp); 
                }else{
                    Gson gson = new Gson();  
                    json = gson.toJson(mensagemNaoDisp); 
                }
                tx.commit();
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            }finally {
                session.close();
            }
            System.out.println(json);
            return json;
        }
    
        public String devolveCodigoPostal(String cp4, String cp3){
        Session session = factory.openSession();
        Transaction tx = null;
        String json = null;
        try{
            tx = session.beginTransaction();
            Query cp = session.createQuery("FROM CodigoPostal C WHERE C.cp4 = :cp4 and C.cp3=:cp3");
            cp.setParameter("cp3", cp3);
            cp.setParameter("cp4", cp4);
            List lista = cp.list();
            Gson gson = new Gson();  
            json = gson.toJson(lista); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        System.out.println(json);
        return json;
    }
}
        

