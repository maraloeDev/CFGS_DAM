pageextension 50100 "Salesperson/Purchasers" extends "Salesperson/Purchaser Card"
{
    layout
    {
        // Add changes to page layout here
        addafter("Phone No.")
        {
            field("Total Sales"; Rec."Total Sales") { ApplicationArea = All; }
        }
    }

}