page 50103 "My Vendor Card"
{
    PageType = Card;
    ApplicationArea = All;
    UsageCategory = Administration;
    SourceTable = Vendor;

    layout
    {
        area(Content)
        {
            group(General)
            {
                Caption = 'General';

                field("No"; Rec."No.")
                {
                    Caption = 'No.';
                }

                field(Name; Rec.Name)
                {

                    Caption = 'Name';
                }

                field(City; Rec.City)
                {

                    Caption = 'City';
                }

                field("Vendor Posting Group"; Rec."Vendor Posting Group")
                {

                    Caption = 'Vendor Posting Group';
                }

                field("Currency Code"; Rec."Currency Code")
                {

                    Caption = 'Currency Code';
                }

                field("Purchaser Code"; Rec."Purchaser Code")
                {

                    Caption = 'Purchaser Code';
                }
                field("Country/Region Code"; Rec."Country/Region Code")
                {

                    Caption = 'Country/Region Code';
                }


            }

            group(Invoicing)
            {

                Caption = 'Invoicing';
                field("Budgeted Amount"; Rec."Budgeted Amount")
                {

                    Caption = 'Budgeted Amount';
                }

                field("Invoice Disc. Code"; Rec."Invoice Disc. Code")
                {

                    Caption = 'Invoice Disc. Code';
                }

                field("Balance (LCY)"; Rec."Balance (LCY)")
                {
                    Caption = 'Balance (LCY)';
                }

                field("Purchases (LCY)"; Rec."Purchases (LCY)")
                {

                    Caption = 'Purchases (LCY)';
                }

                field("Inv. Discounts (LCY)"; Rec."Inv. Discounts (LCY)")
                {

                    Caption = 'Inv. Discounts (LCY)';
                }

                field("Amt. Rcd. Not Invoiced (LCY)"; Rec."Amt. Rcd. Not Invoiced (LCY)")
                {

                    Caption = 'Amt. Rcd. Not Invoiced (LCY)';
                }
            }
        }
        area(FactBoxes)
        {
            
            part("Vendor Details FactBox"; "Vendor Details FactBox")
            {
                ApplicationArea = All;
                SubPageLink = "No." = field("No.");
            }
        }

        //Incluir un FactBox que muestre 
        // el numero de compras que se han realizado al proveedor maximo y minimo


    }

    actions
    {
        area(Processing)
        {
            action(ActionName)
            {
                ApplicationArea = All;

                trigger OnAction()
                begin

                end;
            }
        }
    }

    var
        myInt: Integer;
}