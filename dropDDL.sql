ALTER TABLE patient_condition DROP FOREIGN KEY FK_patient_condition_patient_id
ALTER TABLE patient_condition DROP FOREIGN KEY FK_patient_condition_diagnosis_id
ALTER TABLE diagnoses DROP KEY UNQ_diagnoses_0
ALTER TABLE patient_needs DROP FOREIGN KEY FK_patient_needs_condition_id
ALTER TABLE media DROP FOREIGN KEY FK_media_campaign_id
ALTER TABLE campaign_donors DROP FOREIGN KEY FK_campaign_donors_campaign_id
ALTER TABLE campaign_donors DROP FOREIGN KEY FK_campaign_donors_donor_id
ALTER TABLE campaign_endorses DROP FOREIGN KEY FK_campaign_endorses_doctor_id
ALTER TABLE campaign_endorses DROP FOREIGN KEY FK_campaign_endorses_campaign_id
ALTER TABLE campaign_followers DROP FOREIGN KEY FK_campaign_followers_campaign_id
ALTER TABLE campaign_followers DROP FOREIGN KEY FK_campaign_followers_follower_id
DROP TABLE patients
DROP TABLE patient_condition
DROP TABLE diagnoses
DROP TABLE patient_needs
DROP TABLE campaigns
DROP TABLE media
DROP TABLE campaign_donors
DROP TABLE campaign_endorses
DROP TABLE campaign_followers
DROP TABLE users
