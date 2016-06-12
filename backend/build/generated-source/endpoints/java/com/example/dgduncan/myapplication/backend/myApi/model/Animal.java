/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2016-05-27 16:00:31 UTC)
 * on 2016-06-11 at 23:03:26 UTC 
 * Modify at your own risk.
 */

package com.example.dgduncan.myapplication.backend.myApi.model;

/**
 * Model definition for Animal.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the myApi. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Animal extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("common_name")
  private java.lang.String commonName;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("current_location")
  private GeoPt currentLocation;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String date;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("days_tracked")
  private java.lang.Integer daysTracked;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("initial_location")
  private GeoPt initialLocation;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String name;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean recent;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer sequence;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String sex;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String size;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String species;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("tagging_video")
  private java.lang.String taggingVideo;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getCommonName() {
    return commonName;
  }

  /**
   * @param commonName commonName or {@code null} for none
   */
  public Animal setCommonName(java.lang.String commonName) {
    this.commonName = commonName;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public GeoPt getCurrentLocation() {
    return currentLocation;
  }

  /**
   * @param currentLocation currentLocation or {@code null} for none
   */
  public Animal setCurrentLocation(GeoPt currentLocation) {
    this.currentLocation = currentLocation;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDate() {
    return date;
  }

  /**
   * @param date date or {@code null} for none
   */
  public Animal setDate(java.lang.String date) {
    this.date = date;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getDaysTracked() {
    return daysTracked;
  }

  /**
   * @param daysTracked daysTracked or {@code null} for none
   */
  public Animal setDaysTracked(java.lang.Integer daysTracked) {
    this.daysTracked = daysTracked;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public Animal setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public GeoPt getInitialLocation() {
    return initialLocation;
  }

  /**
   * @param initialLocation initialLocation or {@code null} for none
   */
  public Animal setInitialLocation(GeoPt initialLocation) {
    this.initialLocation = initialLocation;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getName() {
    return name;
  }

  /**
   * @param name name or {@code null} for none
   */
  public Animal setName(java.lang.String name) {
    this.name = name;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getRecent() {
    return recent;
  }

  /**
   * @param recent recent or {@code null} for none
   */
  public Animal setRecent(java.lang.Boolean recent) {
    this.recent = recent;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getSequence() {
    return sequence;
  }

  /**
   * @param sequence sequence or {@code null} for none
   */
  public Animal setSequence(java.lang.Integer sequence) {
    this.sequence = sequence;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getSex() {
    return sex;
  }

  /**
   * @param sex sex or {@code null} for none
   */
  public Animal setSex(java.lang.String sex) {
    this.sex = sex;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getSize() {
    return size;
  }

  /**
   * @param size size or {@code null} for none
   */
  public Animal setSize(java.lang.String size) {
    this.size = size;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getSpecies() {
    return species;
  }

  /**
   * @param species species or {@code null} for none
   */
  public Animal setSpecies(java.lang.String species) {
    this.species = species;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getTaggingVideo() {
    return taggingVideo;
  }

  /**
   * @param taggingVideo taggingVideo or {@code null} for none
   */
  public Animal setTaggingVideo(java.lang.String taggingVideo) {
    this.taggingVideo = taggingVideo;
    return this;
  }

  @Override
  public Animal set(String fieldName, Object value) {
    return (Animal) super.set(fieldName, value);
  }

  @Override
  public Animal clone() {
    return (Animal) super.clone();
  }

}
