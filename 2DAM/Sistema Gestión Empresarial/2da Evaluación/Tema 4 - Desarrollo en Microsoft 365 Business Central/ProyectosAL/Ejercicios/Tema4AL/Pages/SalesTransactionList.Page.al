page 50101 "Sales Transaction"
{
    PageType = List;
    ApplicationArea = All;
    UsageCategory = Lists;
    SourceTable = "Sales Transaction";

    layout
    {
        area(Content)
        {
            repeater(GroupName)
            {
                field("Line No."; Rec."Line NO.") { ApplicationArea = all; }
                field("Salesperson Code"; Rec."Salesperson Code") { ApplicationArea = all; }
                field("Type"; Rec.Type) { ApplicationArea = all; }
                field("No."; Rec."NO.") { ApplicationArea = all; }
                field(Amount; Rec.Amount) { ApplicationArea = all; }
            }
        }
        area(Factboxes)
        {

        }
    }

    actions
    {
        area(Processing)
        {
            action(ActionName)
            {
                ApplicationArea = All;

                trigger OnAction();
                begin

                end;
            }
        }
    }
}