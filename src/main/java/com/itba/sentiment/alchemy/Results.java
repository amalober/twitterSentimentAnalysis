package com.itba.sentiment.alchemy;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="usage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="totalTransactions" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="docSentiment"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="score" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *                   &lt;element name="mixed" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="keywords"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="keyword" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="relevance" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="concepts"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="concept" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="relevance" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *                             &lt;element name="dbpedia" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *                             &lt;element name="freebase" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
 *                             &lt;element name="opencyc" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
 *                             &lt;element name="yago" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="entities"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="entity" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="relevance" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *                             &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *                             &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="disambiguated" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="subType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                       &lt;element name="website" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *                                       &lt;element name="dbpedia" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *                                       &lt;element name="freebase" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *                                       &lt;element name="yago" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="relations"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="relation" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="sentence" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="subject"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="keywords" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="keyword"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                                         &lt;/sequence&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/complexContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="action"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="lemmatized" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="verb"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                                 &lt;element name="tense" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                                 &lt;element name="negated" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="object" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="entities" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="entity"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                                           &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                                           &lt;element name="disambiguated"&gt;
 *                                                             &lt;complexType&gt;
 *                                                               &lt;complexContent&gt;
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                   &lt;sequence&gt;
 *                                                                     &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                                                     &lt;element name="subType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                                                     &lt;element name="website" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *                                                                     &lt;element name="dbpedia" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *                                                                     &lt;element name="freebase" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *                                                                     &lt;element name="yago" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *                                                                   &lt;/sequence&gt;
 *                                                                 &lt;/restriction&gt;
 *                                                               &lt;/complexContent&gt;
 *                                                             &lt;/complexType&gt;
 *                                                           &lt;/element&gt;
 *                                                         &lt;/sequence&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/complexContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="keywords" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="keyword" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                                         &lt;/sequence&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/complexContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="location" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="taxonomy"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="element" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="confident" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="score" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "status",
    "usage",
    "totalTransactions",
    "language",
    "docSentiment",
    "keywords",
    "concepts",
    "entities",
    "relations",
    "taxonomy"
})
@XmlRootElement(name = "results")
public class Results {

    @XmlElement(required = true)
    protected String status;
    @XmlElement(required = true)
    protected String usage;
    protected byte totalTransactions;
    @XmlElement(required = true)
    protected String language;
    @XmlElement(required = true)
    protected Results.DocSentiment docSentiment;
    @XmlElement(required = true)
    protected Results.Keywords keywords;
    @XmlElement(required = true)
    protected Results.Concepts concepts;
    @XmlElement(required = true)
    protected Results.Entities entities;
    @XmlElement(required = true)
    protected Results.Relations relations;
    @XmlElement(required = true)
    protected Results.Taxonomy taxonomy;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the usage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsage() {
        return usage;
    }

    /**
     * Sets the value of the usage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsage(String value) {
        this.usage = value;
    }

    /**
     * Gets the value of the totalTransactions property.
     * 
     */
    public byte getTotalTransactions() {
        return totalTransactions;
    }

    /**
     * Sets the value of the totalTransactions property.
     * 
     */
    public void setTotalTransactions(byte value) {
        this.totalTransactions = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the docSentiment property.
     * 
     * @return
     *     possible object is
     *     {@link Results.DocSentiment }
     *     
     */
    public Results.DocSentiment getDocSentiment() {
        return docSentiment;
    }

    /**
     * Sets the value of the docSentiment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.DocSentiment }
     *     
     */
    public void setDocSentiment(Results.DocSentiment value) {
        this.docSentiment = value;
    }

    /**
     * Gets the value of the keywords property.
     * 
     * @return
     *     possible object is
     *     {@link Results.Keywords }
     *     
     */
    public Results.Keywords getKeywords() {
        return keywords;
    }

    /**
     * Sets the value of the keywords property.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.Keywords }
     *     
     */
    public void setKeywords(Results.Keywords value) {
        this.keywords = value;
    }

    /**
     * Gets the value of the concepts property.
     * 
     * @return
     *     possible object is
     *     {@link Results.Concepts }
     *     
     */
    public Results.Concepts getConcepts() {
        return concepts;
    }

    /**
     * Sets the value of the concepts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.Concepts }
     *     
     */
    public void setConcepts(Results.Concepts value) {
        this.concepts = value;
    }

    /**
     * Gets the value of the entities property.
     * 
     * @return
     *     possible object is
     *     {@link Results.Entities }
     *     
     */
    public Results.Entities getEntities() {
        return entities;
    }

    /**
     * Sets the value of the entities property.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.Entities }
     *     
     */
    public void setEntities(Results.Entities value) {
        this.entities = value;
    }

    /**
     * Gets the value of the relations property.
     * 
     * @return
     *     possible object is
     *     {@link Results.Relations }
     *     
     */
    public Results.Relations getRelations() {
        return relations;
    }

    /**
     * Sets the value of the relations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.Relations }
     *     
     */
    public void setRelations(Results.Relations value) {
        this.relations = value;
    }

    /**
     * Gets the value of the taxonomy property.
     * 
     * @return
     *     possible object is
     *     {@link Results.Taxonomy }
     *     
     */
    public Results.Taxonomy getTaxonomy() {
        return taxonomy;
    }

    /**
     * Sets the value of the taxonomy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Results.Taxonomy }
     *     
     */
    public void setTaxonomy(Results.Taxonomy value) {
        this.taxonomy = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="concept" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="relevance" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
     *                   &lt;element name="dbpedia" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
     *                   &lt;element name="freebase" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
     *                   &lt;element name="opencyc" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
     *                   &lt;element name="yago" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "concept"
    })
    public static class Concepts {

        protected List<Results.Concepts.Concept> concept;

        /**
         * Gets the value of the concept property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the concept property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getConcept().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Results.Concepts.Concept }
         * 
         * 
         */
        public List<Results.Concepts.Concept> getConcept() {
            if (concept == null) {
                concept = new ArrayList<Results.Concepts.Concept>();
            }
            return this.concept;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="relevance" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
         *         &lt;element name="dbpedia" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
         *         &lt;element name="freebase" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
         *         &lt;element name="opencyc" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
         *         &lt;element name="yago" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "text",
            "relevance",
            "dbpedia",
            "freebase",
            "opencyc",
            "yago"
        })
        public static class Concept {

            @XmlElement(required = true)
            protected String text;
            protected float relevance;
            @XmlElement(required = true)
            @XmlSchemaType(name = "anyURI")
            protected String dbpedia;
            @XmlSchemaType(name = "anyURI")
            protected String freebase;
            @XmlSchemaType(name = "anyURI")
            protected String opencyc;
            @XmlSchemaType(name = "anyURI")
            protected String yago;

            /**
             * Gets the value of the text property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getText() {
                return text;
            }

            /**
             * Sets the value of the text property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setText(String value) {
                this.text = value;
            }

            /**
             * Gets the value of the relevance property.
             * 
             */
            public float getRelevance() {
                return relevance;
            }

            /**
             * Sets the value of the relevance property.
             * 
             */
            public void setRelevance(float value) {
                this.relevance = value;
            }

            /**
             * Gets the value of the dbpedia property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDbpedia() {
                return dbpedia;
            }

            /**
             * Sets the value of the dbpedia property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDbpedia(String value) {
                this.dbpedia = value;
            }

            /**
             * Gets the value of the freebase property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFreebase() {
                return freebase;
            }

            /**
             * Sets the value of the freebase property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFreebase(String value) {
                this.freebase = value;
            }

            /**
             * Gets the value of the opencyc property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOpencyc() {
                return opencyc;
            }

            /**
             * Sets the value of the opencyc property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOpencyc(String value) {
                this.opencyc = value;
            }

            /**
             * Gets the value of the yago property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getYago() {
                return yago;
            }

            /**
             * Sets the value of the yago property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setYago(String value) {
                this.yago = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="score" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
     *         &lt;element name="mixed" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "type",
        "score",
        "mixed"
    })
    public static class DocSentiment {

        @XmlElement(required = true)
        protected String type;
        protected float score;
        protected byte mixed;

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        /**
         * Gets the value of the score property.
         * 
         */
        public float getScore() {
            return score;
        }

        /**
         * Sets the value of the score property.
         * 
         */
        public void setScore(float value) {
            this.score = value;
        }

        /**
         * Gets the value of the mixed property.
         * 
         */
        public byte getMixed() {
            return mixed;
        }

        /**
         * Sets the value of the mixed property.
         * 
         */
        public void setMixed(byte value) {
            this.mixed = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="entity" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="relevance" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
     *                   &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
     *                   &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="disambiguated" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="subType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                             &lt;element name="website" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
     *                             &lt;element name="dbpedia" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
     *                             &lt;element name="freebase" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
     *                             &lt;element name="yago" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entity"
    })
    public static class Entities {

        protected List<Results.Entities.Entity> entity;

        /**
         * Gets the value of the entity property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entity property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntity().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Results.Entities.Entity }
         * 
         * 
         */
        public List<Results.Entities.Entity> getEntity() {
            if (entity == null) {
                entity = new ArrayList<Results.Entities.Entity>();
            }
            return this.entity;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="relevance" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
         *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
         *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="disambiguated" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="subType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
         *                   &lt;element name="website" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
         *                   &lt;element name="dbpedia" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
         *                   &lt;element name="freebase" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
         *                   &lt;element name="yago" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "type",
            "relevance",
            "count",
            "text",
            "disambiguated"
        })
        public static class Entity {

            @XmlElement(required = true)
            protected String type;
            protected float relevance;
            protected byte count;
            @XmlElement(required = true)
            protected String text;
            protected Results.Entities.Entity.Disambiguated disambiguated;

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }

            /**
             * Gets the value of the relevance property.
             * 
             */
            public float getRelevance() {
                return relevance;
            }

            /**
             * Sets the value of the relevance property.
             * 
             */
            public void setRelevance(float value) {
                this.relevance = value;
            }

            /**
             * Gets the value of the count property.
             * 
             */
            public byte getCount() {
                return count;
            }

            /**
             * Sets the value of the count property.
             * 
             */
            public void setCount(byte value) {
                this.count = value;
            }

            /**
             * Gets the value of the text property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getText() {
                return text;
            }

            /**
             * Sets the value of the text property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setText(String value) {
                this.text = value;
            }

            /**
             * Gets the value of the disambiguated property.
             * 
             * @return
             *     possible object is
             *     {@link Results.Entities.Entity.Disambiguated }
             *     
             */
            public Results.Entities.Entity.Disambiguated getDisambiguated() {
                return disambiguated;
            }

            /**
             * Sets the value of the disambiguated property.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Entities.Entity.Disambiguated }
             *     
             */
            public void setDisambiguated(Results.Entities.Entity.Disambiguated value) {
                this.disambiguated = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="subType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
             *         &lt;element name="website" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
             *         &lt;element name="dbpedia" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
             *         &lt;element name="freebase" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
             *         &lt;element name="yago" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "name",
                "subType",
                "website",
                "dbpedia",
                "freebase",
                "yago"
            })
            public static class Disambiguated {

                @XmlElement(required = true)
                protected String name;
                protected List<String> subType;
                @XmlElement(required = true)
                @XmlSchemaType(name = "anyURI")
                protected String website;
                @XmlElement(required = true)
                @XmlSchemaType(name = "anyURI")
                protected String dbpedia;
                @XmlElement(required = true)
                @XmlSchemaType(name = "anyURI")
                protected String freebase;
                @XmlElement(required = true)
                @XmlSchemaType(name = "anyURI")
                protected String yago;

                /**
                 * Gets the value of the name property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * Sets the value of the name property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

                /**
                 * Gets the value of the subType property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the subType property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getSubType().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link String }
                 * 
                 * 
                 */
                public List<String> getSubType() {
                    if (subType == null) {
                        subType = new ArrayList<String>();
                    }
                    return this.subType;
                }

                /**
                 * Gets the value of the website property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getWebsite() {
                    return website;
                }

                /**
                 * Sets the value of the website property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setWebsite(String value) {
                    this.website = value;
                }

                /**
                 * Gets the value of the dbpedia property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDbpedia() {
                    return dbpedia;
                }

                /**
                 * Sets the value of the dbpedia property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDbpedia(String value) {
                    this.dbpedia = value;
                }

                /**
                 * Gets the value of the freebase property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFreebase() {
                    return freebase;
                }

                /**
                 * Sets the value of the freebase property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFreebase(String value) {
                    this.freebase = value;
                }

                /**
                 * Gets the value of the yago property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getYago() {
                    return yago;
                }

                /**
                 * Sets the value of the yago property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setYago(String value) {
                    this.yago = value;
                }

            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="keyword" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="relevance" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "keyword"
    })
    public static class Keywords {

        protected List<Results.Keywords.Keyword> keyword;

        /**
         * Gets the value of the keyword property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the keyword property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getKeyword().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Results.Keywords.Keyword }
         * 
         * 
         */
        public List<Results.Keywords.Keyword> getKeyword() {
            if (keyword == null) {
                keyword = new ArrayList<Results.Keywords.Keyword>();
            }
            return this.keyword;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="relevance" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "text",
            "relevance"
        })
        public static class Keyword {

            @XmlElement(required = true)
            protected String text;
            protected float relevance;

            /**
             * Gets the value of the text property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getText() {
                return text;
            }

            /**
             * Sets the value of the text property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setText(String value) {
                this.text = value;
            }

            /**
             * Gets the value of the relevance property.
             * 
             */
            public float getRelevance() {
                return relevance;
            }

            /**
             * Sets the value of the relevance property.
             * 
             */
            public void setRelevance(float value) {
                this.relevance = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="relation" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="sentence" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="subject"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="keywords" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="keyword"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                                               &lt;/sequence&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/complexContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="action"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="lemmatized" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="verb"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                                       &lt;element name="tense" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                                       &lt;element name="negated" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="object" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="entities" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="entity"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                                                 &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                                                 &lt;element name="disambiguated"&gt;
     *                                                   &lt;complexType&gt;
     *                                                     &lt;complexContent&gt;
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                         &lt;sequence&gt;
     *                                                           &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                                                           &lt;element name="subType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                                                           &lt;element name="website" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
     *                                                           &lt;element name="dbpedia" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
     *                                                           &lt;element name="freebase" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
     *                                                           &lt;element name="yago" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
     *                                                         &lt;/sequence&gt;
     *                                                       &lt;/restriction&gt;
     *                                                     &lt;/complexContent&gt;
     *                                                   &lt;/complexType&gt;
     *                                                 &lt;/element&gt;
     *                                               &lt;/sequence&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/complexContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="keywords" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="keyword" maxOccurs="unbounded" minOccurs="0"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                                               &lt;/sequence&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/complexContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="location" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "relation"
    })
    public static class Relations {

        protected List<Results.Relations.Relation> relation;

        /**
         * Gets the value of the relation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the relation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRelation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Results.Relations.Relation }
         * 
         * 
         */
        public List<Results.Relations.Relation> getRelation() {
            if (relation == null) {
                relation = new ArrayList<Results.Relations.Relation>();
            }
            return this.relation;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="sentence" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="subject"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="keywords" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="keyword"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                                     &lt;/sequence&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/complexContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="action"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="lemmatized" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="verb"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                             &lt;element name="tense" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                             &lt;element name="negated" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="object" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="entities" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="entity"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                                       &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                                       &lt;element name="disambiguated"&gt;
         *                                         &lt;complexType&gt;
         *                                           &lt;complexContent&gt;
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                               &lt;sequence&gt;
         *                                                 &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                                                 &lt;element name="subType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
         *                                                 &lt;element name="website" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
         *                                                 &lt;element name="dbpedia" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
         *                                                 &lt;element name="freebase" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
         *                                                 &lt;element name="yago" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
         *                                               &lt;/sequence&gt;
         *                                             &lt;/restriction&gt;
         *                                           &lt;/complexContent&gt;
         *                                         &lt;/complexType&gt;
         *                                       &lt;/element&gt;
         *                                     &lt;/sequence&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/complexContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="keywords" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="keyword" maxOccurs="unbounded" minOccurs="0"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                                     &lt;/sequence&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/complexContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="location" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "sentence",
            "subject",
            "action",
            "object",
            "location"
        })
        public static class Relation {

            @XmlElement(required = true)
            protected String sentence;
            @XmlElement(required = true)
            protected Results.Relations.Relation.Subject subject;
            @XmlElement(required = true)
            protected Results.Relations.Relation.Action action;
            protected Results.Relations.Relation.Object object;
            protected Results.Relations.Relation.Location location;

            /**
             * Gets the value of the sentence property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSentence() {
                return sentence;
            }

            /**
             * Sets the value of the sentence property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSentence(String value) {
                this.sentence = value;
            }

            /**
             * Gets the value of the subject property.
             * 
             * @return
             *     possible object is
             *     {@link Results.Relations.Relation.Subject }
             *     
             */
            public Results.Relations.Relation.Subject getSubject() {
                return subject;
            }

            /**
             * Sets the value of the subject property.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Relations.Relation.Subject }
             *     
             */
            public void setSubject(Results.Relations.Relation.Subject value) {
                this.subject = value;
            }

            /**
             * Gets the value of the action property.
             * 
             * @return
             *     possible object is
             *     {@link Results.Relations.Relation.Action }
             *     
             */
            public Results.Relations.Relation.Action getAction() {
                return action;
            }

            /**
             * Sets the value of the action property.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Relations.Relation.Action }
             *     
             */
            public void setAction(Results.Relations.Relation.Action value) {
                this.action = value;
            }

            /**
             * Gets the value of the object property.
             * 
             * @return
             *     possible object is
             *     {@link Results.Relations.Relation.Object }
             *     
             */
            public Results.Relations.Relation.Object getObject() {
                return object;
            }

            /**
             * Sets the value of the object property.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Relations.Relation.Object }
             *     
             */
            public void setObject(Results.Relations.Relation.Object value) {
                this.object = value;
            }

            /**
             * Gets the value of the location property.
             * 
             * @return
             *     possible object is
             *     {@link Results.Relations.Relation.Location }
             *     
             */
            public Results.Relations.Relation.Location getLocation() {
                return location;
            }

            /**
             * Sets the value of the location property.
             * 
             * @param value
             *     allowed object is
             *     {@link Results.Relations.Relation.Location }
             *     
             */
            public void setLocation(Results.Relations.Relation.Location value) {
                this.location = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="lemmatized" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="verb"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *                   &lt;element name="tense" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *                   &lt;element name="negated" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "text",
                "lemmatized",
                "verb"
            })
            public static class Action {

                @XmlElement(required = true)
                protected String text;
                @XmlElement(required = true)
                protected String lemmatized;
                @XmlElement(required = true)
                protected Results.Relations.Relation.Action.Verb verb;

                /**
                 * Gets the value of the text property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getText() {
                    return text;
                }

                /**
                 * Sets the value of the text property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setText(String value) {
                    this.text = value;
                }

                /**
                 * Gets the value of the lemmatized property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLemmatized() {
                    return lemmatized;
                }

                /**
                 * Sets the value of the lemmatized property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLemmatized(String value) {
                    this.lemmatized = value;
                }

                /**
                 * Gets the value of the verb property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Results.Relations.Relation.Action.Verb }
                 *     
                 */
                public Results.Relations.Relation.Action.Verb getVerb() {
                    return verb;
                }

                /**
                 * Sets the value of the verb property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Results.Relations.Relation.Action.Verb }
                 *     
                 */
                public void setVerb(Results.Relations.Relation.Action.Verb value) {
                    this.verb = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
                 *         &lt;element name="tense" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
                 *         &lt;element name="negated" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/&gt;
                 *       &lt;/sequence&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "text",
                    "tense",
                    "negated"
                })
                public static class Verb {

                    @XmlElement(required = true)
                    protected String text;
                    @XmlElement(required = true)
                    protected String tense;
                    protected Byte negated;

                    /**
                     * Gets the value of the text property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getText() {
                        return text;
                    }

                    /**
                     * Sets the value of the text property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setText(String value) {
                        this.text = value;
                    }

                    /**
                     * Gets the value of the tense property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTense() {
                        return tense;
                    }

                    /**
                     * Sets the value of the tense property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTense(String value) {
                        this.tense = value;
                    }

                    /**
                     * Gets the value of the negated property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Byte }
                     *     
                     */
                    public Byte getNegated() {
                        return negated;
                    }

                    /**
                     * Sets the value of the negated property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Byte }
                     *     
                     */
                    public void setNegated(Byte value) {
                        this.negated = value;
                    }

                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "text"
            })
            public static class Location {

                @XmlElement(required = true)
                protected String text;

                /**
                 * Gets the value of the text property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getText() {
                    return text;
                }

                /**
                 * Sets the value of the text property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setText(String value) {
                    this.text = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="entities" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="entity"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;sequence&gt;
             *                             &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *                             &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *                             &lt;element name="disambiguated"&gt;
             *                               &lt;complexType&gt;
             *                                 &lt;complexContent&gt;
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                     &lt;sequence&gt;
             *                                       &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *                                       &lt;element name="subType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
             *                                       &lt;element name="website" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
             *                                       &lt;element name="dbpedia" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
             *                                       &lt;element name="freebase" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
             *                                       &lt;element name="yago" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
             *                                     &lt;/sequence&gt;
             *                                   &lt;/restriction&gt;
             *                                 &lt;/complexContent&gt;
             *                               &lt;/complexType&gt;
             *                             &lt;/element&gt;
             *                           &lt;/sequence&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/complexContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="keywords" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="keyword" maxOccurs="unbounded" minOccurs="0"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;sequence&gt;
             *                             &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *                           &lt;/sequence&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/complexContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "text",
                "entities",
                "keywords"
            })
            public static class Object {

                @XmlElement(required = true)
                protected String text;
                protected Results.Relations.Relation.Object.Entities entities;
                protected Results.Relations.Relation.Object.Keywords keywords;

                /**
                 * Gets the value of the text property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getText() {
                    return text;
                }

                /**
                 * Sets the value of the text property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setText(String value) {
                    this.text = value;
                }

                /**
                 * Gets the value of the entities property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Results.Relations.Relation.Object.Entities }
                 *     
                 */
                public Results.Relations.Relation.Object.Entities getEntities() {
                    return entities;
                }

                /**
                 * Sets the value of the entities property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Results.Relations.Relation.Object.Entities }
                 *     
                 */
                public void setEntities(Results.Relations.Relation.Object.Entities value) {
                    this.entities = value;
                }

                /**
                 * Gets the value of the keywords property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Results.Relations.Relation.Object.Keywords }
                 *     
                 */
                public Results.Relations.Relation.Object.Keywords getKeywords() {
                    return keywords;
                }

                /**
                 * Sets the value of the keywords property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Results.Relations.Relation.Object.Keywords }
                 *     
                 */
                public void setKeywords(Results.Relations.Relation.Object.Keywords value) {
                    this.keywords = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="entity"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
                 *                   &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
                 *                   &lt;element name="disambiguated"&gt;
                 *                     &lt;complexType&gt;
                 *                       &lt;complexContent&gt;
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                           &lt;sequence&gt;
                 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
                 *                             &lt;element name="subType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
                 *                             &lt;element name="website" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
                 *                             &lt;element name="dbpedia" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
                 *                             &lt;element name="freebase" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
                 *                             &lt;element name="yago" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
                 *                           &lt;/sequence&gt;
                 *                         &lt;/restriction&gt;
                 *                       &lt;/complexContent&gt;
                 *                     &lt;/complexType&gt;
                 *                   &lt;/element&gt;
                 *                 &lt;/sequence&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/complexContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *       &lt;/sequence&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "entity"
                })
                public static class Entities {

                    @XmlElement(required = true)
                    protected Results.Relations.Relation.Object.Entities.Entity entity;

                    /**
                     * Gets the value of the entity property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Results.Relations.Relation.Object.Entities.Entity }
                     *     
                     */
                    public Results.Relations.Relation.Object.Entities.Entity getEntity() {
                        return entity;
                    }

                    /**
                     * Sets the value of the entity property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Results.Relations.Relation.Object.Entities.Entity }
                     *     
                     */
                    public void setEntity(Results.Relations.Relation.Object.Entities.Entity value) {
                        this.entity = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType&gt;
                     *   &lt;complexContent&gt;
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *       &lt;sequence&gt;
                     *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
                     *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
                     *         &lt;element name="disambiguated"&gt;
                     *           &lt;complexType&gt;
                     *             &lt;complexContent&gt;
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                 &lt;sequence&gt;
                     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
                     *                   &lt;element name="subType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
                     *                   &lt;element name="website" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
                     *                   &lt;element name="dbpedia" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
                     *                   &lt;element name="freebase" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
                     *                   &lt;element name="yago" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
                     *                 &lt;/sequence&gt;
                     *               &lt;/restriction&gt;
                     *             &lt;/complexContent&gt;
                     *           &lt;/complexType&gt;
                     *         &lt;/element&gt;
                     *       &lt;/sequence&gt;
                     *     &lt;/restriction&gt;
                     *   &lt;/complexContent&gt;
                     * &lt;/complexType&gt;
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "type",
                        "text",
                        "disambiguated"
                    })
                    public static class Entity {

                        @XmlElement(required = true)
                        protected String type;
                        @XmlElement(required = true)
                        protected String text;
                        @XmlElement(required = true)
                        protected Results.Relations.Relation.Object.Entities.Entity.Disambiguated disambiguated;

                        /**
                         * Gets the value of the type property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getType() {
                            return type;
                        }

                        /**
                         * Sets the value of the type property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setType(String value) {
                            this.type = value;
                        }

                        /**
                         * Gets the value of the text property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getText() {
                            return text;
                        }

                        /**
                         * Sets the value of the text property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setText(String value) {
                            this.text = value;
                        }

                        /**
                         * Gets the value of the disambiguated property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link Results.Relations.Relation.Object.Entities.Entity.Disambiguated }
                         *     
                         */
                        public Results.Relations.Relation.Object.Entities.Entity.Disambiguated getDisambiguated() {
                            return disambiguated;
                        }

                        /**
                         * Sets the value of the disambiguated property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link Results.Relations.Relation.Object.Entities.Entity.Disambiguated }
                         *     
                         */
                        public void setDisambiguated(Results.Relations.Relation.Object.Entities.Entity.Disambiguated value) {
                            this.disambiguated = value;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType&gt;
                         *   &lt;complexContent&gt;
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *       &lt;sequence&gt;
                         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
                         *         &lt;element name="subType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
                         *         &lt;element name="website" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
                         *         &lt;element name="dbpedia" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
                         *         &lt;element name="freebase" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
                         *         &lt;element name="yago" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
                         *       &lt;/sequence&gt;
                         *     &lt;/restriction&gt;
                         *   &lt;/complexContent&gt;
                         * &lt;/complexType&gt;
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "name",
                            "subType",
                            "website",
                            "dbpedia",
                            "freebase",
                            "yago"
                        })
                        public static class Disambiguated {

                            @XmlElement(required = true)
                            protected String name;
                            protected List<String> subType;
                            @XmlElement(required = true)
                            @XmlSchemaType(name = "anyURI")
                            protected String website;
                            @XmlElement(required = true)
                            @XmlSchemaType(name = "anyURI")
                            protected String dbpedia;
                            @XmlElement(required = true)
                            @XmlSchemaType(name = "anyURI")
                            protected String freebase;
                            @XmlElement(required = true)
                            @XmlSchemaType(name = "anyURI")
                            protected String yago;

                            /**
                             * Gets the value of the name property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getName() {
                                return name;
                            }

                            /**
                             * Sets the value of the name property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setName(String value) {
                                this.name = value;
                            }

                            /**
                             * Gets the value of the subType property.
                             * 
                             * <p>
                             * This accessor method returns a reference to the live list,
                             * not a snapshot. Therefore any modification you make to the
                             * returned list will be present inside the JAXB object.
                             * This is why there is not a <CODE>set</CODE> method for the subType property.
                             * 
                             * <p>
                             * For example, to add a new item, do as follows:
                             * <pre>
                             *    getSubType().add(newItem);
                             * </pre>
                             * 
                             * 
                             * <p>
                             * Objects of the following type(s) are allowed in the list
                             * {@link String }
                             * 
                             * 
                             */
                            public List<String> getSubType() {
                                if (subType == null) {
                                    subType = new ArrayList<String>();
                                }
                                return this.subType;
                            }

                            /**
                             * Gets the value of the website property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getWebsite() {
                                return website;
                            }

                            /**
                             * Sets the value of the website property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setWebsite(String value) {
                                this.website = value;
                            }

                            /**
                             * Gets the value of the dbpedia property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getDbpedia() {
                                return dbpedia;
                            }

                            /**
                             * Sets the value of the dbpedia property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setDbpedia(String value) {
                                this.dbpedia = value;
                            }

                            /**
                             * Gets the value of the freebase property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getFreebase() {
                                return freebase;
                            }

                            /**
                             * Sets the value of the freebase property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setFreebase(String value) {
                                this.freebase = value;
                            }

                            /**
                             * Gets the value of the yago property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getYago() {
                                return yago;
                            }

                            /**
                             * Sets the value of the yago property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setYago(String value) {
                                this.yago = value;
                            }

                        }

                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="keyword" maxOccurs="unbounded" minOccurs="0"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
                 *                 &lt;/sequence&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/complexContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *       &lt;/sequence&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "keyword"
                })
                public static class Keywords {

                    protected List<Results.Relations.Relation.Object.Keywords.Keyword> keyword;

                    /**
                     * Gets the value of the keyword property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the keyword property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getKeyword().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link Results.Relations.Relation.Object.Keywords.Keyword }
                     * 
                     * 
                     */
                    public List<Results.Relations.Relation.Object.Keywords.Keyword> getKeyword() {
                        if (keyword == null) {
                            keyword = new ArrayList<Results.Relations.Relation.Object.Keywords.Keyword>();
                        }
                        return this.keyword;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType&gt;
                     *   &lt;complexContent&gt;
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *       &lt;sequence&gt;
                     *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
                     *       &lt;/sequence&gt;
                     *     &lt;/restriction&gt;
                     *   &lt;/complexContent&gt;
                     * &lt;/complexType&gt;
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "text"
                    })
                    public static class Keyword {

                        @XmlElement(required = true)
                        protected String text;

                        /**
                         * Gets the value of the text property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getText() {
                            return text;
                        }

                        /**
                         * Sets the value of the text property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setText(String value) {
                            this.text = value;
                        }

                    }

                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="keywords" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="keyword"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;sequence&gt;
             *                             &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *                           &lt;/sequence&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/complexContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "text",
                "keywords"
            })
            public static class Subject {

                @XmlElement(required = true)
                protected String text;
                protected Results.Relations.Relation.Subject.Keywords keywords;

                /**
                 * Gets the value of the text property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getText() {
                    return text;
                }

                /**
                 * Sets the value of the text property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setText(String value) {
                    this.text = value;
                }

                /**
                 * Gets the value of the keywords property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Results.Relations.Relation.Subject.Keywords }
                 *     
                 */
                public Results.Relations.Relation.Subject.Keywords getKeywords() {
                    return keywords;
                }

                /**
                 * Sets the value of the keywords property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Results.Relations.Relation.Subject.Keywords }
                 *     
                 */
                public void setKeywords(Results.Relations.Relation.Subject.Keywords value) {
                    this.keywords = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="keyword"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
                 *                 &lt;/sequence&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/complexContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *       &lt;/sequence&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "keyword"
                })
                public static class Keywords {

                    @XmlElement(required = true)
                    protected Results.Relations.Relation.Subject.Keywords.Keyword keyword;

                    /**
                     * Gets the value of the keyword property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Results.Relations.Relation.Subject.Keywords.Keyword }
                     *     
                     */
                    public Results.Relations.Relation.Subject.Keywords.Keyword getKeyword() {
                        return keyword;
                    }

                    /**
                     * Sets the value of the keyword property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Results.Relations.Relation.Subject.Keywords.Keyword }
                     *     
                     */
                    public void setKeyword(Results.Relations.Relation.Subject.Keywords.Keyword value) {
                        this.keyword = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType&gt;
                     *   &lt;complexContent&gt;
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *       &lt;sequence&gt;
                     *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
                     *       &lt;/sequence&gt;
                     *     &lt;/restriction&gt;
                     *   &lt;/complexContent&gt;
                     * &lt;/complexType&gt;
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "text"
                    })
                    public static class Keyword {

                        @XmlElement(required = true)
                        protected String text;

                        /**
                         * Gets the value of the text property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getText() {
                            return text;
                        }

                        /**
                         * Sets the value of the text property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setText(String value) {
                            this.text = value;
                        }

                    }

                }

            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="element" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="confident" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="score" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "element"
    })
    public static class Taxonomy {

        protected List<Results.Taxonomy.Element> element;

        /**
         * Gets the value of the element property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the element property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getElement().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Results.Taxonomy.Element }
         * 
         * 
         */
        public List<Results.Taxonomy.Element> getElement() {
            if (element == null) {
                element = new ArrayList<Results.Taxonomy.Element>();
            }
            return this.element;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="confident" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="score" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "confident",
            "label",
            "score"
        })
        public static class Element {

            protected String confident;
            @XmlElement(required = true)
            protected String label;
            protected float score;

            /**
             * Gets the value of the confident property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getConfident() {
                return confident;
            }

            /**
             * Sets the value of the confident property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setConfident(String value) {
                this.confident = value;
            }

            /**
             * Gets the value of the label property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLabel() {
                return label;
            }

            /**
             * Sets the value of the label property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLabel(String value) {
                this.label = value;
            }

            /**
             * Gets the value of the score property.
             * 
             */
            public float getScore() {
                return score;
            }

            /**
             * Sets the value of the score property.
             * 
             */
            public void setScore(float value) {
                this.score = value;
            }

        }

    }

}
