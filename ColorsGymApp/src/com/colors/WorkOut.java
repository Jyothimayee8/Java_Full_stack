package com.colors;

public class WorkOut {
 String wtype;
 String equipment;
 int weight;
 int repet;
 String reason;
 public WorkOut(String wtype, String equipment, int weight, int repet, String reason) {
	super();
	this.wtype = wtype;
	this.equipment = equipment;
	this.weight = weight;
	this.repet = repet;
	this.reason = reason;
 }
 public String getWtype() {
	return wtype;
 }
 public void setWtype(String wtype) {
	this.wtype = wtype;
 }
 public String getEquipment() {
	return equipment;
 }
 public void setEquipment(String equipment) {
	this.equipment = equipment;
 }
 public int getWeight() {
	return weight;
 }
 public void setWeight(int weight) {
	this.weight = weight;
 }
 public int getRepet() {
	return repet;
 }
 public void setRepet(int repet) {
	this.repet = repet;
 }
 public String getReason() {
	return reason;
 }
 public void setReason(String reason) {
	this.reason = reason;
 }
 @Override
 public String toString() {
	return "WorkOut [wtype=" + wtype + ", equipment=" + equipment + ", weight=" + weight + ", repet=" + repet
			+ ", reason=" + reason + "]";
 }
 

}
 