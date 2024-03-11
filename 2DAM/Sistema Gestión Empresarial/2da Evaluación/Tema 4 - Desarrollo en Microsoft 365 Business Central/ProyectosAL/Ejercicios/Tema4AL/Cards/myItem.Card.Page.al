page 50102 "My Item Card"
{
    PageType = Card;
    ApplicationArea = All;
    UsageCategory = Administration;
    SourceTable = Item;
    Caption = 'My Item Card', comment = 'ESP="Mi ficha producto de tipo producto"';


    // Area de contenido de la pagina
    layout
    {
        area(Content)
        {
            // Son los desplegables de la pagina
            group(General)
            {
                Caption = 'General';

                field("No."; Rec."No.")
                {
                    ApplicationArea = All;
                    Caption = 'Code', comment = 'ESP="Codigo"';
                    Importance = Promoted;
                }

                field("Description"; Rec.Description)
                {
                    ApplicationArea = All;
                    Caption = 'Description', comment = 'ESP="Descripcion"';
                    ToolTip = 'Description of the item';
                    Importance = Promoted;
                }
            }

            group(Detalles)
            {
                Caption = 'Detalles';

                field("Costing Method"; Rec."Costing Method")
                {
                    Caption = 'EnglishText', comment = 'ESP="YourLanguageText"';
                    ApplicationArea = All;
                }

                field("Unit Cost"; Rec."Unit Cost")
                {
                    Caption = 'Unit Cost';
                    ApplicationArea = All;
                    Importance = Additional;
                }

                field("Profit %"; Rec."Profit %")
                {
                    Caption = 'Profit %';
                    ApplicationArea = All;
                    ToolTip = 'Is the percentage of profit that you want to obtain';
                }
            }
        }
    }
    actions
    {
        area(Reporting)
        {
            action(ActionName)
            {
                ApplicationArea = All;

                trigger OnAction()
                begin

                end;
            }
        }

        area(Processing)
        {
            action(ItemTurnover)

            {
                Caption = 'Item Turnover';
                ApplicationArea = All;
                RunObject = Page "Item Turnover";
                RunPageLink = "No." = FIELD("No.");
                Promoted = true;
            }
        }
    }
}