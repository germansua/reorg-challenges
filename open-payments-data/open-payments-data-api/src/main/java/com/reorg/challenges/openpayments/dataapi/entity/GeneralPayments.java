package com.reorg.challenges.openpayments.dataapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralPayments {

    private String changeType;
    private String coveredRecipientType;
    private String teachingHospitalCCN;
    private String teachingHospitalID;
    private String teachingHospitalName;
    @Id private String coveredRecipientProfileID;
    private String coveredRecipientNPI;
    private String coveredRecipientFirstName;
    private String coveredRecipientMiddleName;
    private String coveredRecipientLastName;
    private String coveredRecipientNameSuffix;
    private String recipientPrimaryBusinessStreetAddressLine1;
    private String recipientPrimaryBusinessStreetAddressLine2;
    private String recipientCity;
    private String recipientState;
    private String recipientZipCode;
    private String recipientCountry;
    private String recipientProvince;
    private String recipientPostalCode;
    private String coveredRecipientPrimaryType1;
    private String coveredRecipientPrimaryType2;
    private String coveredRecipientPrimaryType3;
    private String coveredRecipientPrimaryType4;
    private String coveredRecipientPrimaryType5;
    private String coveredRecipientPrimaryType6;
    private String coveredRecipientSpecialty1;
    private String coveredRecipientSpecialty2;
    private String coveredRecipientSpecialty3;
    private String coveredRecipientSpecialty4;
    private String coveredRecipientSpecialty5;
    private String coveredRecipientSpecialty6;
    private String coveredRecipientLicenseStatecode1;
    private String coveredRecipientLicenseStatecode2;
    private String coveredRecipientLicenseStatecode3;
    private String coveredRecipientLicenseStatecode4;
    private String coveredRecipientLicenseStatecode5;
    private String submittingApplicableManufacturerOrApplicableGPOName;
    private String applicableManufacturerOrApplicableGPOMakingPaymentID;
    private String applicableManufacturerOrApplicableGPOMakingPaymentName;
    private String applicableManufacturerOrApplicableGPOMakingPaymentState;
    private String applicableManufacturerOrApplicableGPOMakingPaymentCountry;
    private String totalAmountOfPaymentUSDollars;
    private String dateOfPayment;
    private String numberOfPaymentsIncludedinTotalAmount;
    private String formOfPaymentOrTransferOfValue;
    private String natureOfPaymentOrTransferOfValue;
    private String cityOfTravel;
    private String stateOfTravel;
    private String countryOfTravel;
    private String physicianOwnershipIndicator;
    private String thirdPartyPaymentRecipientIndicator;
    private String nameOfThirdPartyEntityReceivingPayment;
    private String charityIndicator;
    private String thirdPartyEqualsCoveredRecipientIndicator;
    private String contextualInformation;
    private String delayinPublicationIndicator;
    private String recordID;
    private String disputeStatusforPublication;
    private String relatedProductIndicator;
    private String coveredOrNoncoveredIndicator1;
    private String indicateDrugOrBiologicalOrDeviceOrMedicalSupply1;
    private String productCategoryOrTherapeuticArea1;
    private String nameOfDrugOrBiologicalOrDeviceOrMedicalSupply1;
    private String associatedDrugOrBiologicalNDC1;
    private String associatedDeviceOrMedicalSupplyPDI1;
    private String coveredOrNoncoveredIndicator2;
    private String indicateDrugOrBiologicalOrDeviceOrMedicalSupply2;
    private String productCategoryOrTherapeuticArea2;
    private String nameOfDrugOrBiologicalOrDeviceOrMedicalSupply2;
    private String associatedDrugOrBiologicalNDC2;
    private String associatedDeviceOrMedicalSupplyPDI2;
    private String coveredOrNoncoveredIndicator3;
    private String indicateDrugOrBiologicalOrDeviceOrMedicalSupply3;
    private String productCategoryOrTherapeuticArea3;
    private String nameOfDrugOrBiologicalOrDeviceOrMedicalSupply3;
    private String associatedDrugOrBiologicalNDC3;
    private String associatedDeviceOrMedicalSupplyPDI3;
    private String coveredOrNoncoveredIndicator4;
    private String indicateDrugOrBiologicalOrDeviceOrMedicalSupply4;
    private String productCategoryOrTherapeuticArea4;
    private String nameOfDrugOrBiologicalOrDeviceOrMedicalSupply4;
    private String associatedDrugOrBiologicalNDC4;
    private String associatedDeviceOrMedicalSupplyPDI4;
    private String coveredOrNoncoveredIndicator5;
    private String indicateDrugOrBiologicalOrDeviceOrMedicalSupply5;
    private String productCategoryOrTherapeuticArea5;
    private String nameOfDrugOrBiologicalOrDeviceOrMedicalSupply5;
    private String associatedDrugOrBiologicalNDC5;
    private String associatedDeviceOrMedicalSupplyPDI5;
    private String programYear;
    private String paymentPublicationDate;
}