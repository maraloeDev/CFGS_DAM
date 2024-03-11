pageextension 50102 "Salesperson/Purcharser" extends "Salespersons/Purchasers"
{
    layout
    {
        addafter("Phone No.")
        {
            field("Total Sales"; Rec."Total Sales") { ApplicationArea = All; }
        }
    }

}