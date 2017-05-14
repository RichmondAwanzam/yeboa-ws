ALTER TABLE patient_condition DROP FOREIGN KEY FK_patient_condition_patient_id
ALTER TABLE patient_condition DROP FOREIGN KEY FK_patient_condition_diagnosis_id
ALTER TABLE diagnoses DROP KEY UNQ_diagnoses_0
ALTER TABLE patient_needs DROP FOREIGN KEY FK_patient_needs_condition_id
ALTER TABLE media DROP FOREIGN KEY FK_media_campaign_id
ALTER TABLE payments DROP FOREIGN KEY FK_payments_paid_to_campaign
DROP TABLE patients
DROP TABLE patient_condition
DROP TABLE diagnoses
DROP TABLE patient_needs
DROP TABLE campaigns
DROP TABLE media
DROP TABLE payments
