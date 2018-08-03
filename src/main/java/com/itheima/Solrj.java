package com.itheima;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

public class Solrj {
    public static void main(String[] args) {
        System.out.println();
    }
    /**
     * 添加索引库
     */
    @Test
    public void addAndUpdate() throws Exception{
        //指定远程服务其地址
        String url = "http://localhost:8080/solr/collection1";
        //创建服务对象,连接远程solr服务
        SolrServer solrServer = new HttpSolrServer(url);
        //创建solrDocument对象
        SolrInputDocument so = new SolrInputDocument();
        so.addField("id","u9999999");
        so.addField("title","卖的价格便宜");
        solrServer.add(so);
        solrServer.commit();
    }
    @Test
    public void delete() throws Exception{
        //指定远程服务其地址
        String url = "http://localhost:8080/solr/collection1";
        //创建服务对象,连接远程solr服务
        SolrServer solrServer = new HttpSolrServer(url);
        solrServer.deleteById("u9999999");
        solrServer.commit();
    }
}
