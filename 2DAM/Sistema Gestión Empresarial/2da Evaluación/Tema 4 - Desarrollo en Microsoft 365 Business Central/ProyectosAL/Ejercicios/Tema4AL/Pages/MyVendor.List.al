page 50104 MyVendorList
{
    PageType = List;
    SourceTable = Vendor;
    Editable = false;
    CardPageID = "My Vendor Card";
    DeleteAllowed = false;


    layout
    {
        area(Content)
        {
            repeater(General)
            {
                field("No."; Rec."No.")
                {
                    ApplicationArea = All;
                    Caption = 'No.';
                    Editable = false;
                }
                field(Name; Rec.Name)
                {
                    ApplicationArea = All;
                    Caption = 'Name';
                    Editable = false;
                }
                field(City; Rec.City)
                {
                    ApplicationArea = All;
                    Caption = 'City';
                    Editable = false;
                }
                field("Vendor Posting Group"; Rec."Vendor Posting Group")
                {
                    ApplicationArea = All;
                    Caption = 'Vendor Posting Group';
                    Editable = false;
                }
                field("Currency Code"; Rec."Currency Code")
                {
                    ApplicationArea = All;
                    Caption = 'Currency Code';
                    Editable = false;
                }
                field("Purchaser Code"; Rec."Purchaser Code")
                {
                    ApplicationArea = All;
                    Caption = 'Purchaser Code';
                    Editable = false;
                }
                field("Country/Region Code"; Rec."Country/Region Code")
                {
                    ApplicationArea = All;
                    Caption = 'Country/Region Code';
                    Editable = false;
                }
            }
        }
    }
}
