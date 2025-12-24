package com.company.supportsystem.domain.model.valueobjects;

import com.company.supportsystem.domain.model.state.*;

public enum TicketStatus {

    CREATED {
        @Override
        public TicketState state() {
            return new CreatedState();
        }
    },
    ASSIGNED {
        @Override
        public TicketState state() {
            return new AssignedState();
        }
    },
    IN_PROGRESS {
        @Override
        public TicketState state() {
            return new InProgressState();
        }
    },
    RESOLVED {
        @Override
        public TicketState state() {
            return new ResolvedState();
        }
    },
    CLOSED {
        @Override
        public TicketState state() {
            return new ClosedState();
        }
    };

    public abstract TicketState state();
}
